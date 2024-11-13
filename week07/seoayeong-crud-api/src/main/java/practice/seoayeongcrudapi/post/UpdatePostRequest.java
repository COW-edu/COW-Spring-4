package practice.seoayeongcrudapi.post;

import lombok.Getter;

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
