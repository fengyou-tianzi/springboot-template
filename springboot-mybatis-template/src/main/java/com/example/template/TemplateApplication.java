package com.example.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 启动类
 * <p>
 * 启动类命名规范: 以 Application 后缀结尾
 * 位置: 放在根包下, 确保 @SpringBootApplication 能扫描到所有子包的组件
 * </p>
 */
@SpringBootApplication
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}
