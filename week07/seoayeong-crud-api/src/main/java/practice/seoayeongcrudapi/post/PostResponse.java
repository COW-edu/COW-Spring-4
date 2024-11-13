package practice.seoayeongcrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {

    private String title;

    private String content;

    private String userId;

    @Builder
    private PostResponse(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .userId(post.getUserId())
                .build();
    }
}