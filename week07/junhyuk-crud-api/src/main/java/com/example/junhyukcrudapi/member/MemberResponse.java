package com.example.junhyukcrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
    private Long id;

    private String userName;

    private String email;

    @Builder
    private MemberResponse(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .userName(member.getName())
                .email(member.getEmail())
                .build();
    }

}
