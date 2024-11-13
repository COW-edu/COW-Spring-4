package practice.kimsioncrudapi.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
  private String title;
  private String content;
  private Integer id;
  private Integer userId;

  @Builder
  public Post(String title, String content, Integer id, Integer userId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.userId = userId;
  }

  public void update(CreatePostRequest createPostRequest) {
    this.title = createPostRequest.getTitle();
    this.content = createPostRequest.getContent();
  }

}
