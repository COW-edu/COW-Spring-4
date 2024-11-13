package practice.jungsukwoocrudapi.post;

import lombok.Builder;

public class Post {

        private int id;
        private int userId;
        private String title;
        private String content;

@Builder
    private Post(int id, int userId, String title, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
