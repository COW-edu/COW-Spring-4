package practice.banghyunwoocrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
    private String username;
    private String email;
    private String password;

    @Builder
    public MemberResponse(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static MemberResponse from(Member member){
        return MemberResponse.builder()
                .username(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
