package practice.banghyunwoocrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
    private int id;
    private String title;
    private String content;
    private int userId;

    @Builder
    public PostResponse(int id, String title, String content, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .userId(post.getUserId())
                .build();
    }
}
