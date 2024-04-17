package com.example.carrot.controller.swagger;

import com.example.carrot.common.BaseResponse;
import com.example.carrot.dto.request.UserCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User 관련 API")
public interface UserApi {
    @Operation(
            summary = "회원 생성 API",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "요청이 성공했습니다."
                    )
            }
    )
    ResponseEntity<BaseResponse<?>> createUser(@RequestBody UserCreateRequest request);
}
