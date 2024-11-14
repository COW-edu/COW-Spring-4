package practice.kimyunjincrudapi.post.controller.dto;

import lombok.Getter;
import practice.kimyunjincrudapi.post.Post;

@Getter
public class CreatePostRequest {
    private String title;
    private String content;
    private Long userId;

    public Post toEntity(Long postId) {
        return Post.builder()
                .id(postId)
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}
