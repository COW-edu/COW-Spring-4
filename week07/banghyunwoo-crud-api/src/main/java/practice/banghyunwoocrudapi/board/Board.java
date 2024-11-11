package practice.banghyunwoocrudapi.board;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {
    private int id;
    private String title;
    private String content;
    private int userId;

    @Builder(toBuilder = true)
    public Board(int id, int userId, String content, String title) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.title = title;
    }
}
