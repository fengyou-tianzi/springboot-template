package com.example.template.common.result;

import com.example.template.common.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结果封装
 * <p>
 * 企业开发中所有接口必须返回统一的响应格式, 前端根据 code 判断请求是否成功。
 * 命名规范: 泛型参数用 T 表示, data 字段存放业务数据。
 * </p>
 *
 * @param <T> 响应数据类型
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    private int code;

    /** 提示信息 */
    private String msg;

    /** 响应数据 */
    private T data;

    /** 时间戳 */
    private long timestamp;

    private Result() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功 - 无数据
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        return result;
    }

    /**
     * 成功 - 带数据
     *
     * @param data 响应数据
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 成功 - 带自定义提示和数据
     *
     * @param msg  提示信息
     * @param data 响应数据
     */
    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 失败 - 使用预定义错误码
     *
     * @param resultCode 错误码枚举
     */
    public static <T> Result<T> fail(ResultCode resultCode) {
        Result<T> result = new Result<>();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        return result;
    }

    /**
     * 失败 - 自定义错误码和提示
     *
     * @param code 状态码
     * @param msg  提示信息
     */
    public static <T> Result<T> fail(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 失败 - 仅提示信息 (状态码默认500)
     *
     * @param msg 提示信息
     */
    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.INTERNAL_ERROR.getCode());
        result.setMsg(msg);
        return result;
    }
}
