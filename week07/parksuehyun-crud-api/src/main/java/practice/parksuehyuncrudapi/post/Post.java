package practice.parksuehyuncrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {
    private static long idCounter = 0;  // ID 생성용 카운터
    private final long id;
    private String title;
    private String content;
    private String userId;

    @Builder
    private Post(String title, String content, String userId) {
        this.id = ++idCounter;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
