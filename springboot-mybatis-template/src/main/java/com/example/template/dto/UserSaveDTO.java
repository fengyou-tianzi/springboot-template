package com.example.template.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户新增/修改 DTO
 * <p>
 * DTO (Data Transfer Object) 命名规范:
 * - 新增: XxxSaveDTO / XxxAddDTO / XxxCreateDTO
 * - 修改: XxxUpdateDTO (如与新增字段不同则单独定义)
 * - 查询: XxxQueryDTO / XxxSearchDTO
 * <p>
 * 企业开发中 DTO 与 Entity 分离, 避免直接暴露数据库字段给前端。
 * 使用 @Valid / @Validated 配合 JSR-303 注解进行参数校验。
 * </p>
 */
@Data
public class UserSaveDTO {

    /** 主键ID (修改时必传, 新增时不传) */
    private Long id;

    /** 用户名 */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 20, message = "用户名长度为3-20个字符")
    private String username;

    /** 密码 */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度为6-20个字符")
    private String password;

    /** 昵称 */
    @Size(max = 30, message = "昵称长度不能超过30个字符")
    private String nickname;

    /** 邮箱 */
    @Email(message = "邮箱格式不正确")
    private String email;

    /** 手机号 */
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    /** 性别 (0-男 1-女 2-未知) */
    private String gender;

    /** 状态 (0-正常 1-禁用) */
    private String status;

    /** 备注 */
    @Size(max = 200, message = "备注长度不能超过200个字符")
    private String remark;
}
