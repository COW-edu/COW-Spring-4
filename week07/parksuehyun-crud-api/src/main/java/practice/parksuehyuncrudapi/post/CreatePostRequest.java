package practice.parksuehyuncrudapi.post;

import lombok.Getter;

@Getter
public class CreatePostRequest {
    private String title;
    private String content;
    private String userId;
    public Post toEntity() {
        return  Post.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}
