package com.example.seminar3.service;

import com.example.seminar3.common.exception.BusinessException;
import com.example.seminar3.common.exception.ErrorStatus;
import com.example.seminar3.domain.Member;
import com.example.seminar3.dto.request.MemberCreateRequest;
import com.example.seminar3.dto.response.MemberCreateResponse;
import com.example.seminar3.dto.response.MemberFindResponse;
import com.example.seminar3.dto.response.MembersFindResponse;
import com.example.seminar3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse createMember(final MemberCreateRequest request) {
        Member member = Member.create(request.name(), request.part(), request.age());
        memberRepository.save(member);
        return MemberCreateResponse.of(member);
    }

    public MemberFindResponse getMemberById(final Long memberId) {
        Member member = findMember(memberId);
        return MemberFindResponse.of(member);
    }

    @Transactional
    public void deleteMemberById(final Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public MembersFindResponse getMembers() {
        List<Member> members = findMembers();
        return MembersFindResponse.of(members);
    }

    private Member findMember(final Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new BusinessException(ErrorStatus.MEMBER_NOT_FOUND)
        );
    }

    private List<Member> findMembers() {
        return memberRepository.findAll();
    }
}