-- ======================== 数据库建表脚本 ========================
-- 企业开发中 SQL 命名规范:
-- 1. 表名: 全小写 + 下划线分隔, 以业务模块前缀开头。如 sys_user, biz_order
-- 2. 字段名: 全小写 + 下划线分隔。如 user_name, create_time
-- 3. 每个表必须有: 主键 id、创建人 create_by、创建时间 create_time、
--    更新人 update_by、更新时间 update_time、删除标记 del_flag、备注 remark
-- 4. 字段必须添加注释 COMMENT
-- 5. 使用 utf8mb4 字符集, 支持 emoji

CREATE DATABASE IF NOT EXISTS `template_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `template_db`;

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `username`    VARCHAR(50)  NOT NULL                COMMENT '用户名',
    `password`    VARCHAR(100) NOT NULL                COMMENT '密码',
    `nickname`    VARCHAR(50)  DEFAULT NULL            COMMENT '昵称',
    `email`       VARCHAR(100) DEFAULT NULL            COMMENT '邮箱',
    `phone`       VARCHAR(20)  DEFAULT NULL            COMMENT '手机号',
    `gender`      CHAR(1)      DEFAULT '2'             COMMENT '性别 (0-男 1-女 2-未知)',
    `status`      CHAR(1)      DEFAULT '0'             COMMENT '状态 (0-正常 1-禁用)',
    `create_by`   VARCHAR(50)  DEFAULT NULL            COMMENT '创建人',
    `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   VARCHAR(50)  DEFAULT NULL            COMMENT '更新人',
    `update_time` DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`    CHAR(1)      DEFAULT '0'             COMMENT '删除标记 (0-未删除 1-已删除)',
    `remark`      VARCHAR(200) DEFAULT NULL            COMMENT '备注',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`) COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- 初始数据
-- ----------------------------
INSERT INTO `sys_user` (`username`, `password`, `nickname`, `gender`, `status`, `create_by`)
VALUES ('admin', 'admin123', '超级管理员', '0', '0', 'system');
