package practice.kimsioncrudapi.post;

import lombok.Builder;
import lombok.Getter;
import practice.kimsioncrudapi.member.MemberResponse;

@Getter
public class PostResponse{

  private String title;
  private String content;
  private Integer id;
  private Integer userId;

  @Builder
  public PostResponse(Integer id,String title, String content, Integer userId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.userId = userId;
  }

  public static PostResponse from(Post post){
    return PostResponse.builder().id(post.getId()).title(post.getTitle()).content(post.getContent()).userId(post.getUserId()).build();
  }

}
