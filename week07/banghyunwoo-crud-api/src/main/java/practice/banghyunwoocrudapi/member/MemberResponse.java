package practice.banghyunwoocrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
    private int id;
    private String username;
    private String email;
    private String password;

    @Builder
    public MemberResponse(int id, String username, String email, String password) {
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
