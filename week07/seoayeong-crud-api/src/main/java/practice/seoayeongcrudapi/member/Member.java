package practice.seoayeongcrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
    private String name;

    private String email;

    private String password;

    @Builder
    private Member (String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}

