package com.example.template.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.example.template.common.enums.ResultCode;
import com.example.template.common.exception.BusinessException;
import com.example.template.dto.UserQueryDTO;
import com.example.template.dto.UserSaveDTO;
import com.example.template.entity.User;
import com.example.template.mapper.UserMapper;
import com.example.template.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户 Service 实现类
 * <p>
 * 实现类命名规范: 接口名 + Impl 后缀。如 UserService -> UserServiceImpl
 * 必须添加 @Service 注解, 交由 Spring 容器管理
 * <p>
 * 企业开发规范:
 * 1. 使用 @RequiredArgsConstructor + final 字段实现构造器注入 (推荐, 替代 @Autowired)
 * 2. 涉及多表操作的方法必须加 @Transactional
 * 3. 业务异常统一抛出 BusinessException
 * 4. 关键操作需记录日志
 * </p>
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * 根据ID查询用户
     */
    @Override
    public User getById(Long id) {
        // 参数校验
        if (id == null) {
            throw new BusinessException(ResultCode.BAD_REQUEST);
        }
        // 查询数据库
        User user = userMapper.selectById(id);
        // 判断是否存在
        if (user == null) {
            throw new BusinessException(ResultCode.USER_NOT_FOUND);
        }
        return user;
    }

    /**
     * 条件分页查询用户列表
     */
    @Override
    public List<User> listPage(UserQueryDTO queryDTO) {
        // 开启分页 (紧跟其后的第一条查询会被分页)
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        // 执行查询
        List<User> list = userMapper.selectList(queryDTO);
        // 用 PageInfo 包装分页信息 (如需返回分页详情可返回 PageInfo 对象)
        PageInfo<User> pageInfo = new PageInfo<>(list);
        log.info("分页查询用户列表, 总数: {}", pageInfo.getTotal());
        return list;
    }

    /**
     * 新增用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserSaveDTO saveDTO) {
        // 校验用户名是否已存在
        checkUsernameUnique(saveDTO.getUsername(), null);
        // DTO 转 Entity
        User user = new User();
        BeanUtil.copyProperties(saveDTO, user);
        // 密码加密 (示例, 实际应使用 BCrypt 等加密方式)
        user.setPassword(saveDTO.getPassword());
        // 设置创建人 (实际从登录信息获取)
        user.setCreateBy("system");
        // 插入数据库
        int rows = userMapper.insert(user);
        if (rows <= 0) {
            throw new BusinessException("新增用户失败");
        }
        log.info("新增用户成功, username={}", saveDTO.getUsername());
    }

    /**
     * 修改用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserSaveDTO saveDTO) {
        // 校验ID不能为空
        if (saveDTO.getId() == null) {
            throw new BusinessException(ResultCode.BAD_REQUEST);
        }
        // 校验用户是否存在
        User existingUser = userMapper.selectById(saveDTO.getId());
        if (existingUser == null) {
            throw new BusinessException(ResultCode.USER_NOT_FOUND);
        }
        // 校验用户名是否与其他用户重复
        checkUsernameUnique(saveDTO.getUsername(), saveDTO.getId());
        // DTO 转 Entity
        User user = new User();
        BeanUtil.copyProperties(saveDTO, user);
        // 设置更新人 (实际从登录信息获取)
        user.setUpdateBy("system");
        // 更新数据库
        int rows = userMapper.updateById(user);
        if (rows <= 0) {
            throw new BusinessException("修改用户失败");
        }
        log.info("修改用户成功, id={}", saveDTO.getId());
    }

    /**
     * 根据ID删除用户 (逻辑删除)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeById(Long id) {
        if (id == null) {
            throw new BusinessException(ResultCode.BAD_REQUEST);
        }
        // 执行逻辑删除
        int rows = userMapper.deleteById(id);
        if (rows <= 0) {
            throw new BusinessException("删除用户失败, 用户不存在");
        }
        log.info("删除用户成功, id={}", id);
    }

    /**
     * 批量逻辑删除用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeBatchIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new BusinessException("请选择要删除的数据");
        }
        // 执行批量逻辑删除
        int rows = userMapper.deleteBatchIds(ids);
        log.info("批量删除用户成功, 删除数量: {}", rows);
    }

    /**
     * 校验用户名唯一性
     *
     * @param username 用户名
     * @param excludeId 排除的用户ID (修改时排除自身)
     */
    private void checkUsernameUnique(String username, Long excludeId) {
        // 用户名为空则不校验
        if (StrUtil.isBlank(username)) {
            return;
        }
        // 根据用户名查询
        User existingUser = userMapper.selectByUsername(username);
        // 已存在且不是同一条记录, 则用户名重复
        if (existingUser != null && !existingUser.getId().equals(excludeId)) {
            throw new BusinessException("用户名已存在");
        }
    }
}
