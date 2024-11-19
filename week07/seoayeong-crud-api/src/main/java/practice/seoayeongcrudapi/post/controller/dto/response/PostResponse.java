package practice.seoayeongcrudapi.post.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.seoayeongcrudapi.post.entity.Post;

@Getter
public class PostResponse {

    private Long id;

    private String title;

    private String content;

    private String userId;

    @Builder
    private PostResponse(Long id, String title, String content, String userId) {
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
                .build();
    }
}