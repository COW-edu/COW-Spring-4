package practice.kimsioncrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

  private String userName;
  private String email;
  private String password;
  private Integer id;

  @Builder
  public MemberResponse(String password, String userName, String email, Integer id) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.id = id;
  }

  public static MemberResponse from(Member member){
    return MemberResponse.builder().id(member.getId()).password(member.getPassword()).userName(member.getName()).email(member.getEmail()).build();
  }

}
