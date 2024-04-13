package com.sopt.practice.controller;

import com.sopt.practice.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "1차 세미나 테스트 API 입니다!";
    }

    @GetMapping("/test/json")
    public ApiResponse testJson() {
        return ApiResponse.create("1차 세미나 테스트 API - JSON");
    }
}
