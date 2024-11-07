package practice.banghyunwoocrudapi.member;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Member {
    private String name;

    private String email;

    private String password;

    @Builder
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
