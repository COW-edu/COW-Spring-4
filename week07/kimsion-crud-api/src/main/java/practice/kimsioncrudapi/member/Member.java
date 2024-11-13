package practice.kimsioncrudapi.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

  private String name;
  private String email;
  private String password;
  private Integer id;

  @Builder // new 키워드
  private Member( String password, String name, String email, Integer id) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.id = id;
  }

  public void update(CreateMemberRequest createMemberRequest) {
    this.name = createMemberRequest.getUsername();
    this.email = createMemberRequest.getEmail();
    this.password = createMemberRequest.getPassword();
  }
}
