package com.example.seminar3.controller;

import com.example.seminar3.common.ApiResponse;
import com.example.seminar3.common.SuccessStatus;
import com.example.seminar3.dto.request.MemberCreateRequest;
import com.example.seminar3.dto.response.MemberCreateResponse;
import com.example.seminar3.dto.response.MemberFindResponse;
import com.example.seminar3.dto.response.MembersFindResponse;
import com.example.seminar3.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<?>> getMember(@PathVariable Long memberId) {
        final MemberFindResponse response = memberService.getMemberById(memberId);
        return ApiResponse.success(SuccessStatus.OK, response);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<ApiResponse<?>> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMemberById(memberId);
        return ApiResponse.success(SuccessStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getMembers() {
        final MembersFindResponse response = memberService.getMembers();
        return ApiResponse.success(SuccessStatus.OK, response);
    }
}

