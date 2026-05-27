package com.example.template.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类
 * <p>
 * 企业开发中所有实体类都应继承此基础类, 包含公共字段。
 * 数据库表中通常都有这些公共字段, 避免每个实体类重复定义。
 * <p>
 * 实体类命名规范: 与数据库表名对应, 驼峰命名。如表 sys_user -> 类 SysUser 或 User
 * 字段命名: 驼峰命名, 与数据库列名对应 (MyBatis 自动映射下划线转驼峰)
 * </p>
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 创建人 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 更新人 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /** 删除标记 (0-未删除 1-已删除) */
    private String delFlag;

    /** 备注 */
    private String remark;
}
