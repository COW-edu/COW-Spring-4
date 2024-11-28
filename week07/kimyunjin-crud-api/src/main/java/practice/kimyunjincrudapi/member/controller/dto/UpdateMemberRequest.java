package practice.kimyunjincrudapi.member.controller.dto;

import lombok.Getter;

@Getter
public class UpdateMemberRequest {
    private String username;
    private String email;
}
