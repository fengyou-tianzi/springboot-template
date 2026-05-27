package com.example.template.common.exception;

import com.example.template.common.enums.ResultCode;
import lombok.Getter;

/**
 * 业务异常类
 * <p>
 * 企业开发中所有业务异常统一抛出此异常, 由全局异常处理器捕获并返回给前端。
 * 命名规范: 以 Exception 后缀结尾
 * 使用方式: throw new BusinessException("用户不存在") 或 throw new BusinessException(ResultCode.USER_NOT_FOUND)
 * </p>
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /** 错误码 */
    private final int code;

    /**
     * 使用预定义错误码构造
     *
     * @param resultCode 错误码枚举
     */
    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    /**
     * 自定义错误码和提示信息
     *
     * @param code 状态码
     * @param msg  提示信息
     */
    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 仅提示信息 (状态码默认业务异常)
     *
     * @param msg 提示信息
     */
    public BusinessException(String msg) {
        super(msg);
        this.code = ResultCode.BUSINESS_ERROR.getCode();
    }
}
