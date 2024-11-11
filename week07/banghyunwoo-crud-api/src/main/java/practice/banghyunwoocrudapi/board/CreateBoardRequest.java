package practice.banghyunwoocrudapi.board;

import lombok.Getter;

@Getter
public class CreateBoardRequest {
    private String title;
    private String content;
    private int userId;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}
