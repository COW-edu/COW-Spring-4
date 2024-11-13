package com.example.junhyukcrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private String title;
    private String content;
    private Long userId; // 작성자의 ID

    @Builder
    public Post(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
