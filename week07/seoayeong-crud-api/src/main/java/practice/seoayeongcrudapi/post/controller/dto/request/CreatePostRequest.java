package practice.seoayeongcrudapi.post.controller.dto.request;

import lombok.Getter;
import practice.seoayeongcrudapi.post.entity.Post;

@Getter
public class CreatePostRequest {

    private String title;

    private String content;

    private String userId;


    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}
