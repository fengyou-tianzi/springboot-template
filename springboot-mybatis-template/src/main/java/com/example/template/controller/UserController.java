package com.example.template.controller;

import com.example.template.common.result.Result;
import com.example.template.dto.UserQueryDTO;
import com.example.template.dto.UserSaveDTO;
import com.example.template.entity.User;
import com.example.template.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户 Controller
 * <p>
 * Controller 命名规范: 以 Controller 后缀结尾, 与实体类名对应。如 User -> UserController
 * <p>
 * 企业开发规范:
 * 1. 类上使用 @RequestMapping 定义模块路径, 如 /user
 * 2. 方法上的 HTTP 方法注解:
 *    - GET: 查询操作
 *    - POST: 新增操作
 *    - PUT: 修改操作
 *    - DELETE: 删除操作
 * 3. 所有接口统一返回 Result<T> 格式
 * 4. 参数校验使用 @Validated 注解
 * 5. 使用 Swagger 注解生成接口文档
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(tags = "用户管理")
public class UserController {

    private final UserService userService;

    /**
     * 根据ID查询用户详情
     */
    @GetMapping("/{id}")
    @ApiOperation("根据ID查询用户详情")
    public Result<User> getById(
            @ApiParam("用户ID") @PathVariable Long id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    /**
     * 条件分页查询用户列表
     */
    @GetMapping("/list")
    @ApiOperation("条件分页查询用户列表")
    public Result<List<User>> listPage(UserQueryDTO queryDTO) {
        List<User> list = userService.listPage(queryDTO);
        // 使用 PageInfo 获取分页信息
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return Result.success(list);
    }

    /**
     * 新增用户
     */
    @PostMapping
    @ApiOperation("新增用户")
    public Result<Void> save(
            @Validated @RequestBody UserSaveDTO saveDTO) {
        userService.save(saveDTO);
        return Result.success();
    }

    /**
     * 修改用户
     */
    @PutMapping
    @ApiOperation("修改用户")
    public Result<Void> update(
            @Validated @RequestBody UserSaveDTO saveDTO) {
        userService.update(saveDTO);
        return Result.success();
    }

    /**
     * 根据ID删除用户
     */
    @DeleteMapping("/{id}")
    @ApiOperation("根据ID删除用户")
    public Result<Void> removeById(
            @ApiParam("用户ID") @PathVariable Long id) {
        userService.removeById(id);
        return Result.success();
    }

    /**
     * 批量删除用户
     */
    @DeleteMapping("/batch")
    @ApiOperation("批量删除用户")
    public Result<Void> removeBatchIds(
            @ApiParam("用户ID列表") @RequestBody List<Long> ids) {
        userService.removeBatchIds(ids);
        return Result.success();
    }
}
