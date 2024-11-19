package practice.seoayeongcrudapi.member.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.seoayeongcrudapi.member.entity.Member;

@Getter
public class MemberResponse {
    private String userName;

    private String email;

    @Builder
    private MemberResponse(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .userName(member.getName())
                .email(member.getEmail())
                .build();
    }
}