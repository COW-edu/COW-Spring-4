package practice.seoayeongcrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {

    private String id;

    private String title;

    private String content;

    private String userId;

    @Builder
    private PostResponse(String id, String title, String content, String userId) {
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