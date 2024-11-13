package practice.jungsukwoocrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

    private String name;
    private String email;
    public String password;

    @Builder
    private Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void updateInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
