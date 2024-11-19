package practice.jungsukwoocrudapi.comment.dto.request;

import lombok.Getter;
import practice.jungsukwoocrudapi.comment.entity.Comment;
import practice.jungsukwoocrudapi.member.entity.Member;

@Getter
public class CreateCommentRequest {

    private Long userId;
    private String content;

    public Comment toEntity(Member member){
        return Comment.builder()
                .content(content)
                .member(member)
                .build();
    }
}
