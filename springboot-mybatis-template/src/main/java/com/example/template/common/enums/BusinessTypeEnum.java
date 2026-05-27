package com.example.template.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务类型枚举
 * <p>
 * 枚举类命名规范: 以 Enum 后缀结尾, 或直接用业务含义命名。
 * 企业开发中枚举通常用于替代魔法值, 提高代码可读性。
 * </p>
 */
@Getter
@AllArgsConstructor
public enum BusinessTypeEnum {

    /** 新增 */
    INSERT("1", "新增"),

    /** 修改 */
    UPDATE("2", "修改"),

    /** 删除 */
    DELETE("3", "删除"),

    /** 导出 */
    EXPORT("4", "导出"),

    /** 导入 */
    IMPORT("5", "导入");

    /** 类型编码 */
    private final String code;

    /** 类型描述 */
    private final String desc;
}
