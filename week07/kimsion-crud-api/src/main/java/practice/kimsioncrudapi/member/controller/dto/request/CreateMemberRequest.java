package practice.kimsioncrudapi.member.controller.dto.request;

import lombok.Getter;
import practice.kimsioncrudapi.member.entity.Member;
import practice.kimsioncrudapi.post.entity.Post;

@Getter
public class CreateMemberRequest { // DTO

  private String username;
  private String email;
  private String password;

  public Member toEntity(){
    return Member.builder()
        .password(password)
        .email(email)
        .name(username)
        .build();
  }
  
}
