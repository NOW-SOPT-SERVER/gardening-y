package com.example.seminar3.service;

import com.example.seminar3.common.exception.BusinessException;
import com.example.seminar3.common.exception.ErrorStatus;
import com.example.seminar3.domain.Blog;
import com.example.seminar3.domain.Member;
import com.example.seminar3.dto.request.BlogCreateRequest;
import com.example.seminar3.dto.request.BlogTitleUpdateRequest;
import com.example.seminar3.dto.response.BlogCreateResponse;
import com.example.seminar3.repository.BlogRepository;
import com.example.seminar3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public BlogCreateResponse createBlog(final Long memberId, final BlogCreateRequest request) {
        Member member = findMember(memberId);
        Blog blog = blogRepository.save(Blog.create(member, request.title(), request.description()));
        return BlogCreateResponse.of(blog);
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findBlog(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }

    private Member findMember(final Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new BusinessException(ErrorStatus.MEMBER_NOT_FOUND)
        );
    }

    private Blog findBlog(final Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new BusinessException(ErrorStatus.BLOG_NOT_FOUND)
        );
    }
}
