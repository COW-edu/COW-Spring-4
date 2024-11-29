package practice.kimsioncrudapi.post.controller.dto.request;

import lombok.Getter;
import practice.kimsioncrudapi.member.entity.Member;
import practice.kimsioncrudapi.post.entity.Post;

@Getter
public class CreatePostRequest {
  private Long memberId;
  private String title;
  private String content;

  public Post toEntity(Member member){
    return Post.builder()
        .title(title)
        .content(content)
        .member(member)
        .build();
  }

}
