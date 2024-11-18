package practice.jungsukwoocrudapi.member.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberRequest {
    private String username;
    private String email;
    private String password;
}
