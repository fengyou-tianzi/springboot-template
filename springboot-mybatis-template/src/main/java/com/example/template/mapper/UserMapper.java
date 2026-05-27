package com.example.template.mapper;

import com.example.template.dto.UserQueryDTO;
import com.example.template.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户 Mapper 接口
 * <p>
 * Mapper 接口命名规范: 以 Mapper 后缀结尾, 与实体类名对应。如 User -> UserMapper
 * 方法命名规范:
 * - 查询单个: selectById / selectOne / selectByUsername
 * - 查询列表: selectList / selectPage
 * - 插入: insert / insertBatch
 * - 更新: updateById / updateStatus
 * - 删除: deleteById / deleteBatchIds
 * - 统计: count / countByCondition
 * <p>
 * 注意: 使用 @MapperScan 批量扫描后, 此处 @Mapper 可省略, 保留仅为示例
 * </p>
 */
@Mapper
public interface UserMapper {

    /**
     * 根据ID查询用户
     *
     * @param id 主键ID
     * @return 用户实体
     */
    User selectById(Long id);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    User selectByUsername(String username);

    /**
     * 条件分页查询用户列表
     *
     * @param queryDTO 查询条件
     * @return 用户列表
     */
    List<User> selectList(UserQueryDTO queryDTO);

    /**
     * 新增用户
     *
     * @param user 用户实体
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 根据ID更新用户 (选择性更新: 只更新非null字段)
     *
     * @param user 用户实体
     * @return 影响行数
     */
    int updateById(User user);

    /**
     * 根据ID删除用户 (逻辑删除)
     *
     * @param id 主键ID
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 批量逻辑删除用户
     *
     * @param ids 主键ID列表
     * @return 影响行数
     */
    int deleteBatchIds(List<Long> ids);
}
