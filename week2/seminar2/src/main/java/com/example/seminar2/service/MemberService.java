package com.example.seminar2.service;

import com.example.seminar2.common.error.BusinessException;
import com.example.seminar2.common.error.ErrorStatus;
import com.example.seminar2.domain.Member;
import com.example.seminar2.dto.request.MemberCreateRequest;
import com.example.seminar2.dto.response.MemberCreateResponse;
import com.example.seminar2.dto.response.MemberFindResponse;
import com.example.seminar2.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse createMember(final MemberCreateRequest request) {
        Member member = Member.create(request.name(), request.part(), request.age());
        memberRepository.save(member);
        return MemberCreateResponse.of(member);
    }

    public MemberFindResponse findMemberById(final Long memberId) {
        Member member = findMember(memberId);
        return MemberFindResponse.of(member);
    }

    @Transactional
    public void deleteMemberById(final Long memberId) {
        memberRepository.deleteById(memberId);
    }

    private Member findMember(final Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new BusinessException(ErrorStatus.MEMBER_NOT_FOUND)
        );
    }
}