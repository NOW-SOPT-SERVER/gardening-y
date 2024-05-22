package com.example.seminar3.service;

import com.example.seminar3.common.exception.BusinessException;
import com.example.seminar3.common.exception.ErrorStatus;
import com.example.seminar3.domain.Blog;
import com.example.seminar3.domain.Post;
import com.example.seminar3.dto.request.PostCreateRequest;
import com.example.seminar3.dto.response.PostCreateResponse;
import com.example.seminar3.dto.response.PostFindResponse;
import com.example.seminar3.repository.BlogRepository;
import com.example.seminar3.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final BlogRepository blogRepository;

    @Transactional
    public PostCreateResponse createPost(final Long blogId, final PostCreateRequest request) {
        Blog blog = findBlog(blogId);
        Post post = Post.create(request.title(), request.content(), blog);
        postRepository.save(post);
        return PostCreateResponse.of(post);
    }

    public PostFindResponse getPostById(final Long postId) {
        Post post = findPostById(postId);
        return PostFindResponse.of(post);
    }

    private Blog findBlog(final Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new BusinessException(ErrorStatus.BLOG_NOT_FOUND)
        );
    }

    private Post findPostById(final Long postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new BusinessException(ErrorStatus.POST_NOT_FOUND)
        );
    }
}
