package practice.jungsukwoocrudapi.member.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.jungsukwoocrudapi.member.entity.Member;

@Getter
public class MemberResponse {

    private String name;
    private String email;
    private String password;

    @Builder
    private MemberResponse(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static MemberResponse from(Member member){
        return MemberResponse.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
