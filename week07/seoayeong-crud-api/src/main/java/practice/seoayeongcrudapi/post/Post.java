package practice.seoayeongcrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private String title;

    private String content;

    private String userId;

    @Builder
    private Post (String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
