package practice.banghyunwoocrudapi.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateMemberRequest {
    private String id;
    private String username;
    private String email;
    private String password;



}
