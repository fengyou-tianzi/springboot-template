package com.example.template.dto;

import lombok.Data;

/**
 * 用户查询条件 DTO
 * <p>
 * 查询 DTO 用于接收前端的查询条件, 通常配合 PageHelper 实现分页查询。
 * 字段使用模糊查询或精确查询, 视业务需求而定。
 * </p>
 */
@Data
public class UserQueryDTO {

    /** 用户名 (模糊查询) */
    private String username;

    /** 昵称 (模糊查询) */
    private String nickname;

    /** 手机号 (精确查询) */
    private String phone;

    /** 状态 (0-正常 1-禁用) */
    private String status;

    /** 页码 (默认1) */
    private Integer pageNum = 1;

    /** 每页条数 (默认10) */
    private Integer pageSize = 10;
}
