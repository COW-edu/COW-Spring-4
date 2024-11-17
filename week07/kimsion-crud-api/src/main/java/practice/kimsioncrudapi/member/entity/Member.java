package practice.kimsioncrudapi.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.kimsioncrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.kimsioncrudapi.post.entity.Post;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  private String name;

  private String email;

  private String password;

  @OneToMany(mappedBy = "member", orphanRemoval = true)
  List<Post> posts = new ArrayList<>();

  @Builder
  private Member(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public void update(CreateMemberRequest createMemberRequest) {
    this.name = createMemberRequest.getUsername();
    this.email = createMemberRequest.getEmail();
    this.password = createMemberRequest.getPassword();
  }
}

