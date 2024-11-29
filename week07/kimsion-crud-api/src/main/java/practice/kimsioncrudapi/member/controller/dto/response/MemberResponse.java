package practice.kimsioncrudapi.member.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.kimsioncrudapi.member.entity.Member;

@Getter
public class MemberResponse {

  private String userName;
  private String email;
  private String password;

  @Builder
  public MemberResponse(String password, String userName, String email) {
    this.userName = userName;
    this.email = email;
    this.password = password;
  }

  public static MemberResponse from(Member member) {
    return MemberResponse.builder()
        .password(member.getPassword())
        .userName(member.getName())
        .email(member.getEmail())
        .build();
  }

}
