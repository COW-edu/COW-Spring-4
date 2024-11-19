package practice.seoayeongcrudapi.member.controller.dto.request;

import lombok.Getter;
import practice.seoayeongcrudapi.member.entity.Member;


@Getter
public class UpdateMemberRequest {

    private String username;

    private String email;

    public Member toEntity() {
        return Member.builder()
                .name(username)
                .email(email)
                .build();
    }
}
