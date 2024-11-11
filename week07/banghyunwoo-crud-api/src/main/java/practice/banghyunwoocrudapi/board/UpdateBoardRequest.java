package practice.banghyunwoocrudapi.board;

import lombok.Getter;

@Getter
public class UpdateBoardRequest {
    private String title;
    private String content;
    private Integer userId;


    public Board getPost(Board board, UpdateBoardRequest updateBoardRequest) {
        return board.toBuilder()
                .title(updateBoardRequest.title != null ? updateBoardRequest.getTitle() : board.getTitle())
                .content(updateBoardRequest.content != null ? updateBoardRequest.getContent() : board.getContent())
                .userId(updateBoardRequest.userId != null ? updateBoardRequest.getUserId() : board.getUserId())
                .build();

    }
}
