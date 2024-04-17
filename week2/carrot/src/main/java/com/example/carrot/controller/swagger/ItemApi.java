package com.example.carrot.controller.swagger;

import com.example.carrot.common.BaseResponse;
import com.example.carrot.dto.request.ItemCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Item 관련 API")
public interface ItemApi {
    @Operation(
            summary = "아이템 생성 API",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "요청이 성공했습니다."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "유저를 찾을 수 없습니다."
                    )
            }
    )
    ResponseEntity<BaseResponse<?>> createItem(@RequestBody ItemCreateRequest request);
}
