package com.example.template;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBoot 测试类
 * <p>
 * 测试类命名规范: 以 Tests 后缀结尾
 * 使用 @SpringBootTest 启动完整的 Spring 上下文
 * </p>
 */
@SpringBootTest
class TemplateApplicationTests {

    // 示例: 注入 Service 进行测试
    // @Autowired
    // private UserService userService;
    //
    // @Test
    // void testGetById() {
    //     User user = userService.getById(1L);
    //     assertNotNull(user);
    // }
}
