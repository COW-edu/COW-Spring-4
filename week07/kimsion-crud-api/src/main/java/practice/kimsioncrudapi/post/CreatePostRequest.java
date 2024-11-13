package practice.kimsioncrudapi.post;

import lombok.Getter;

@Getter
public class CreatePostRequest {
  private String title;
  private String content;
  private Integer userId;
  private Integer id;

  public CreatePostRequest(String title, String content, Integer userId, Integer id) {
    this.title = title;
    this.content = content;
    this.userId = userId;
    this.id = id;
  }

  public Post toEntity(){
    return Post.builder()
        .id(id)
        .title(title)
        .content(content)
        .userId(userId)
        .build();
  }

}
