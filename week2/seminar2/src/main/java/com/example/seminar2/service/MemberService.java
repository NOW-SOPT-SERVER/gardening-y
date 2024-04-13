package com.example.seminar2.service;

import com.example.seminar2.domain.Member;
import com.example.seminar2.dto.request.MemberCreateRequest;
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
    public String createMember(final MemberCreateRequest request) {
        Member member = Member.create(request.name(), request.part(), request.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

    public MemberFindResponse findMemberById(final Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        );
        return MemberFindResponse.of(member);
    }

    @Transactional
    public void deleteMemberById(final Long memberId) {
        memberRepository.deleteById(memberId);
    }
}