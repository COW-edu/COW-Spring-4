package practice.kimsioncrudapi.member;

import lombok.Getter;

@Getter
public class CreateMemberRequest { // DTO

  private String username;
  private String email;
  private String password;
  private Integer id;

  public Member toEntity(){
    return Member.builder()
        .password(password) //
        .name(username) //
        .email(email) //
        .id(id)
        .build();
  }
}
