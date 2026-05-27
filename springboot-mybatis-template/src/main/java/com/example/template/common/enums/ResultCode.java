package com.example.template.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态码枚举
 * <p>
 * 企业开发中状态码规范:
 * - 2xxxx: 成功
 * - 4xxxx: 客户端错误 (参数校验、认证授权等)
 * - 5xxxx: 服务端错误
 * <p>
 * 命名规范: 全大写 + 下划线分隔
 * </p>
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    // ==================== 成功 ====================
    SUCCESS(20000, "操作成功"),

    // ==================== 客户端错误 4xxxx ====================
    BAD_REQUEST(40000, "请求参数错误"),
    PARAM_VALID_ERROR(40001, "参数校验失败"),
    UNAUTHORIZED(40100, "未登录或登录已过期"),
    FORBIDDEN(40300, "无访问权限"),
    NOT_FOUND(40400, "请求资源不存在"),
    METHOD_NOT_ALLOWED(40500, "请求方法不允许"),

    // ==================== 服务端错误 5xxxx ====================
    INTERNAL_ERROR(50000, "系统内部错误"),
    SERVICE_UNAVAILABLE(50001, "服务暂不可用"),
    DB_ERROR(50002, "数据库操作异常"),
    DUPLICATE_KEY(50003, "数据已存在,请勿重复操作"),

    // ==================== 业务错误 Bxxxx ====================
    BUSINESS_ERROR(60000, "业务处理异常"),
    USER_NOT_FOUND(60001, "用户不存在"),
    USER_ACCOUNT_DISABLED(60002, "用户账号已被禁用"),
    USER_PASSWORD_ERROR(60003, "用户密码错误");

    /** 状态码 */
    private final int code;

    /** 提示信息 */
    private final String msg;
}
