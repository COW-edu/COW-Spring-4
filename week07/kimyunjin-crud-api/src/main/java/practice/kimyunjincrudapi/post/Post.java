package practice.kimyunjincrudapi.post;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {
    private Long id;
    private String title;
    private String content;
    private Long userId;

    @Builder
    public Post(Long id, String title, String content, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public void update(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
    }
}
