package com.example.template.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 * <p>
 * 实体类对应数据库表, 字段与表列一一对应。
 * 使用 @EqualsAndHashCode(callSuper = true) 确保父类字段也参与 equals/hashCode 计算。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 用户名 */
    private String username;

    /** 密码 (加密存储) */
    private String password;

    /** 昵称 */
    private String nickname;

    /** 邮箱 */
    private String email;

    /** 手机号 */
    private String phone;

    /** 性别 (0-男 1-女 2-未知) */
    private String gender;

    /** 状态 (0-正常 1-禁用) */
    private String status;
}
