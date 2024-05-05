package com.example.carrot.controller;

import com.example.carrot.common.BaseResponse;
import com.example.carrot.common.SuccessStatus;
import com.example.carrot.controller.swagger.ItemApi;
import com.example.carrot.dto.request.ItemCreateRequest;
import com.example.carrot.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController implements ItemApi {
    private final ItemService itemService;

    @PostMapping
    @Override
    public ResponseEntity<BaseResponse<?>> createItem(@RequestBody ItemCreateRequest request) {
        itemService.createItem(request);
        return BaseResponse.success(SuccessStatus.CREATED);
    }
}
