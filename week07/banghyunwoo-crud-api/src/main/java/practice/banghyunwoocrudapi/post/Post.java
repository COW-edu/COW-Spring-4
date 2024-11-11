package practice.banghyunwoocrudapi.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String content;
    private int userId;

    @Builder(toBuilder = true)
    public Post(int id, int userId, String content, String title) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.title = title;
    }
}
