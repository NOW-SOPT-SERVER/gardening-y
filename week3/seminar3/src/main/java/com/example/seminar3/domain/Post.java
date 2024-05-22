package com.example.seminar3.domain;

import com.example.seminar3.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    public static Post create(String title, String content, Blog blog) {
        return Post.builder()
                .title(title)
                .content(content)
                .blog(blog)
                .build();
    }
}
