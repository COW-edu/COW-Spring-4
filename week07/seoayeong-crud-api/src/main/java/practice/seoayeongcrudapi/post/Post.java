package practice.seoayeongcrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private String id;

    private String title;

    private String content;

    private String userId;

    @Builder
    private Post (String id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
