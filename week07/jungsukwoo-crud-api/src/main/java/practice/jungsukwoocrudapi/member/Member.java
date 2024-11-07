package practice.jungsukwoocrudapi.member;

import lombok.Builder;
import lombok.Getter;
//이 코드에서 게터 어노테이션 어떻게 작동하는건지 확인 필요, 걍 전체적으로 어노테이션 역할 확인 요망
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
}
