package practice.jungsukwoocrudapi.member.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberRequest {
    private String name;
    private String email;
    private String password;
}
