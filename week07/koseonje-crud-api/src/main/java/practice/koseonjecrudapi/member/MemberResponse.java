package practice.koseonjecrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    private String userName;

    private String email;

    private String password;

    @Builder
    private MemberResponse(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .userName(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
