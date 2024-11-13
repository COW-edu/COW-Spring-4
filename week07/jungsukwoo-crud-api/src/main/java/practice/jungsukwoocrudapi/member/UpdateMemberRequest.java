package practice.jungsukwoocrudapi.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateMemberRequest {
    private String username;
    private String email;
}
