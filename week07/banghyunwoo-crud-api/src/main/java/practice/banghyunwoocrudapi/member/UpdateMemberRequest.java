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

    public static Member getMember(Member updateMemberRequest, Member member) {
        Member updatedMember = member.toBuilder()
                .name(updateMemberRequest.getName() != null ? updateMemberRequest.getName() : member.getName())
                .email(updateMemberRequest.getEmail() != null ? updateMemberRequest.getEmail() : member.getEmail())
                .password(updateMemberRequest.getPassword() != null ? updateMemberRequest.getPassword() : member.getPassword())
                .build();
        return updatedMember;
    }

}
