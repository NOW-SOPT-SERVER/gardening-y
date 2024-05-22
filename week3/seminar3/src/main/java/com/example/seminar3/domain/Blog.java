package com.example.seminar3.domain;

import com.example.seminar3.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(Member member, String title, String description) {
        return Blog.builder()
               .member(member)
               .title(title)
               .description(description)
               .build();
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
