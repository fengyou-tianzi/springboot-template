package com.example.template.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 配置
 * <p>
 * 用于配置拦截器、静态资源映射、消息转换器等。
 * 企业开发中如需添加拦截器, 在此注册。
 * </p>
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 示例: 注册拦截器
    // @Autowired
    // private AuthInterceptor authInterceptor;
    //
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(authInterceptor)
    //             .addPathPatterns("/**")
    //             .excludePathPatterns("/auth/login", "/auth/register");
    // }
}
