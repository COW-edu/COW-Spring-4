package com.example.junhyukcrudapi.comment;

import lombok.Builder;

public class CommentResponse {

    private Long id;
    private String content;
    private Long userId;
    private Long postId;

    @Builder
    private CommentResponse(Long id, String content, Long userId, Long postId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }

    public static CommentResponse from(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userId(comment.getUserId())
                .postId(comment.getPostId())
                .build();
    }
}
