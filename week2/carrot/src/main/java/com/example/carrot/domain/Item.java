package com.example.carrot.domain;

import com.example.carrot.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    private boolean suggestion;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private String local;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public static Item createItem(String title, int price, boolean suggestion, String description, Category category, String local, User user) {
        return builder()
                .title(title)
                .price(price)
                .suggestion(suggestion)
                .description(description)
                .category(category)
                .local(local)
                .user(user)
                .build();
    }
}
