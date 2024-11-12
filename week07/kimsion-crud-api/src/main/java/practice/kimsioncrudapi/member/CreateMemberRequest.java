package practice.kimsioncrudapi.member;

import lombok.Getter;

@Getter
public class CreateMemberRequest { // DTO

  private String username;
  private String email;
  private String password;

  public Member toEntity(){
    return Member.builder()
        .name(username) //
        .email(email) //
        .password(password) //
        .build();
  }
}
