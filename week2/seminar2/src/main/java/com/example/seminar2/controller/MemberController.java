package com.example.seminar2.controller;

import com.example.seminar2.common.ApiResponse;
import com.example.seminar2.common.SuccessStatus;
import com.example.seminar2.dto.request.MemberCreateRequest;
import com.example.seminar2.dto.response.MemberCreateResponse;
import com.example.seminar2.dto.response.MemberFindResponse;
import com.example.seminar2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> postMember(@RequestBody MemberCreateRequest request) {
        final MemberCreateResponse response = memberService.createMember(request);
        return ApiResponse.success(SuccessStatus.CREATED, response);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<?>> findMemberById(@PathVariable Long memberId) {
        memberService.findMemberById(memberId);
        return ApiResponse.success(SuccessStatus.OK);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<ApiResponse<?>> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMemberById(memberId);
        return ApiResponse.success(SuccessStatus.OK);
    }
}

