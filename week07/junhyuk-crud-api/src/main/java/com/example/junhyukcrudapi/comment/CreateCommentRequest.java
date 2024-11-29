package com.example.junhyukcrudapi.comment;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private String content;
    private Long userId;

}
