package practice.banghyunwoocrudapi.board;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponse {
    private int id;
    private String title;
    private String content;
    private int userId;

    @Builder
    public BoardResponse(int id, String title, String content, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public static BoardResponse from(Board board){
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .userId(board.getUserId())
                .build();
    }


}
