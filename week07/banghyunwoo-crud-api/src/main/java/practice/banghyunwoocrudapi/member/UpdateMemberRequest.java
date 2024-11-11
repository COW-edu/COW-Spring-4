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

    public static Member getMember(UpdateMemberRequest updateMemberRequest, Member member) {
        return member.toBuilder()
                .name(updateMemberRequest.getUsername() != null ? updateMemberRequest.getUsername() : member.getName())
                .email(updateMemberRequest.getEmail() != null ? updateMemberRequest.getEmail() : member.getEmail())
                .password(updateMemberRequest.getPassword() != null ? updateMemberRequest.getPassword() : member.getPassword())
                .build();
    }

}
