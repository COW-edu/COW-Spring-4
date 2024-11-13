package practice.jungsukwoocrudapi.member;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private String name;
    private String email;
}
