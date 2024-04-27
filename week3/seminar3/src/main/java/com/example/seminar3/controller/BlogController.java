package com.example.seminar3.controller;

import com.example.seminar3.common.ApiResponse;
import com.example.seminar3.common.SuccessStatus;
import com.example.seminar3.dto.request.BlogCreateRequest;
import com.example.seminar3.dto.request.BlogTitleUpdateRequest;
import com.example.seminar3.dto.response.BlogCreateResponse;
import com.example.seminar3.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<ApiResponse<?>> createBlog(@RequestHeader Long memberId, @RequestBody BlogCreateRequest request) {
        final BlogCreateResponse response = blogService.createBlog(memberId, request);
        return ApiResponse.success(SuccessStatus.CREATED, response);
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity<ApiResponse<?>> updateBlogTitle(@PathVariable Long blogId, @RequestBody BlogTitleUpdateRequest request) {
        blogService.updateTitle(blogId, request);
        return ApiResponse.success(SuccessStatus.OK);
    }
}
