package practice.seoayeongcrudapi.post.controller.dto.request;

import lombok.Getter;
import practice.seoayeongcrudapi.post.entity.Post;

@Getter
public class UpdatePostRequest {

    private String title;

    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
