package practice.kimsioncrudapi.post.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.kimsioncrudapi.post.entity.Post;

@Getter
public class PostResponse {

  private String title;
  private String content;
  private Long id;
  private Long memberId;

  @Builder
  private PostResponse(Long id, String title, String content, Long memberId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.memberId = memberId;
  }

  public static PostResponse from(Post post) {
    return PostResponse.builder()
        .id(post.getId())
        .title(post.getTitle())
        .content(post.getContent())
        .memberId(post.getMember().getId())
        .build();
  }

}
