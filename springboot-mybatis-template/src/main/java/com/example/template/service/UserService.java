package com.example.template.service;

import com.example.template.dto.UserQueryDTO;
import com.example.template.dto.UserSaveDTO;
import com.example.template.entity.User;

import java.util.List;

/**
 * 用户 Service 接口
 * <p>
 * Service 接口命名规范: 以 Service 后缀结尾, 与实体类名对应。如 User -> UserService
 * 方法命名规范:
 * - 查询单个: getById / getByUsername
 * - 查询列表: list / listPage
 * - 新增: save / add
 * - 修改: update / updateById
 * - 删除: remove / removeById / removeBatchIds
 * - 统计: count
 * <p>
 * 企业开发中 Service 接口方法命名应体现业务语义, 而非简单的 CRUD
 * </p>
 */
public interface UserService {

    /**
     * 根据ID查询用户
     *
     * @param id 主键ID
     * @return 用户实体
     */
    User getById(Long id);

    /**
     * 条件分页查询用户列表
     *
     * @param queryDTO 查询条件
     * @return 用户列表
     */
    List<User> listPage(UserQueryDTO queryDTO);

    /**
     * 新增用户
     *
     * @param saveDTO 用户保存DTO
     */
    void save(UserSaveDTO saveDTO);

    /**
     * 修改用户
     *
     * @param saveDTO 用户保存DTO (必须包含id)
     */
    void update(UserSaveDTO saveDTO);

    /**
     * 根据ID删除用户 (逻辑删除)
     *
     * @param id 主键ID
     */
    void removeById(Long id);

    /**
     * 批量逻辑删除用户
     *
     * @param ids 主键ID列表
     */
    void removeBatchIds(List<Long> ids);
}
