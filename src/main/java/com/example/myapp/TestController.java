package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 基础测试接口（不依赖数据库）
    @GetMapping("/")
    public String hello() {
        return "Hello MyApp!";
    }

    // 数据库测试接口
    @GetMapping("/test")
    public String test() {
        // 查询 user 表数量（防止关键字冲突用反引号）
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `user`", Integer.class);

        return "Hello, there are " + count + " users in the myapp database!";
    }
}