package com.example.carrot.controller;

import com.example.carrot.common.BaseResponse;
import com.example.carrot.common.SuccessStatus;
import com.example.carrot.controller.swagger.UserApi;
import com.example.carrot.dto.request.UserCreateRequest;
import com.example.carrot.dto.response.UserCreateResponse;
import com.example.carrot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController implements UserApi {
    private final UserService userService;

    @PostMapping
    @Override
    public ResponseEntity<BaseResponse<?>> createUser(@RequestBody UserCreateRequest request) {
        UserCreateResponse response = userService.createUser(request);
        return BaseResponse.success(SuccessStatus.CREATED, response);
    }
}
