package com.example.template.common.constant;

/**
 * 通用常量类
 * <p>
 * 常量类命名规范: 以 Constant 后缀结尾
 * 常量字段命名: 全大写 + 下划线分隔
 * 企业开发中常量类用于管理项目中的固定值, 避免硬编码
 * </p>
 */
public class CommonConstant {

    /** UTF-8 字符集 */
    public static final String UTF8 = "UTF-8";

    /** 成功标记 */
    public static final Integer SUCCESS = 20000;

    /** 失败标记 */
    public static final Integer FAIL = 50000;

    /** 登录令牌 Header Key */
    public static final String TOKEN_HEADER = "Authorization";

    /** 令牌前缀 */
    public static final String TOKEN_PREFIX = "Bearer ";

    /** 默认页码 */
    public static final Integer DEFAULT_PAGE_NUM = 1;

    /** 默认每页条数 */
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    /** 是 */
    public static final String YES = "1";

    /** 否 */
    public static final String NO = "0";

    /** 正常状态 */
    public static final String STATUS_NORMAL = "0";

    /** 禁用状态 */
    public static final String STATUS_DISABLED = "1";

    /** 删除标记 - 已删除 */
    public static final String DEL_FLAG_DELETED = "1";

    /** 删除标记 - 未删除 */
    public static final String DEL_FLAG_NORMAL = "0";
}
