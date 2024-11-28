package com.example.junhyukcrudapi.comment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Comment {
    private Long id;
    private String content;
    private Long userId;
    private Long postId;

    @Builder
    public Comment(Long id, String content, Long userId, Long postId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }

    public void updateContent(String newContent) {
        this.content = newContent;
    }
}
