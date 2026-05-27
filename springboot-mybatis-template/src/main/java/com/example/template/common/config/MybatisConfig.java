package com.example.template.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 配置类
 * <p>
 * @MapperScan 指定 Mapper 接口所在包路径, 替代在每个 Mapper 接口上加 @Mapper 注解。
 * 企业开发中推荐使用 @MapperScan 批量扫描, 避免遗漏。
 * </p>
 */
@Configuration
@MapperScan("com.example.template.mapper")
public class MybatisConfig {
}
