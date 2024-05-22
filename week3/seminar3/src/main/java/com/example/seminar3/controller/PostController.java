package com.example.seminar3.controller;

import com.example.seminar3.common.ApiResponse;
import com.example.seminar3.common.SuccessStatus;
import com.example.seminar3.dto.request.PostCreateRequest;
import com.example.seminar3.dto.response.PostCreateResponse;
import com.example.seminar3.dto.response.PostFindResponse;
import com.example.seminar3.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createPost(@PathVariable Long blogId, @RequestBody PostCreateRequest request) {
        final PostCreateResponse response = postService.createPost(blogId, request);
        return ApiResponse.success(SuccessStatus.CREATED, response);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<?>> getPost(@PathVariable Long postId) {
        final PostFindResponse response = postService.getPostById(postId);
        return ApiResponse.success(SuccessStatus.OK, response);
    }
}
