package practice.banghyunwoocrudapi.member;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Member {
    private int id;

    private String name;

    private String email;

    private String password;

    @Builder
    public Member(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
