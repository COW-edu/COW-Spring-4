package practice.kimyunjincrudapi.member.controller.dto;

import lombok.Builder;
import lombok.Getter;
import practice.kimyunjincrudapi.member.Member;

@Getter
public class MemberResponse {

    private Long id;
    private String username;
    private String email;

    @Builder
    private MemberResponse(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .username(member.getName())
                .email(member.getEmail())
                .build();
    }
}
