package com.example.seminar2.controller;

import com.example.seminar2.dto.request.MemberCreateRequest;
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
    public ResponseEntity postMember(@RequestBody MemberCreateRequest request) {
        return ResponseEntity.created(URI.create(memberService.createMember(request)))
                .build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindResponse> findMemberById(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
}

