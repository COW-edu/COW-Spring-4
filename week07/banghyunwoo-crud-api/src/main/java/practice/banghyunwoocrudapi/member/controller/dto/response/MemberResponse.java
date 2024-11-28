package practice.banghyunwoocrudapi.member.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.banghyunwoocrudapi.member.entity.Member;

@Getter
public class MemberResponse {
    private Long id;
    private String username;
    private String email;
    private String password;

    @Builder
    public MemberResponse(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static MemberResponse from(Member member){
        return MemberResponse.builder()
                .id(member.getId())
                .username(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
