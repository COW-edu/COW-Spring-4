package practice.jungsukwoocrudapi.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import practice.jungsukwoocrudapi.comment.entity.Comment;

@Getter
@AllArgsConstructor
@Builder
public class CommentResponse {

    private Long id;
    private String content;
    private Long userId;
    private Long postId;

    public static CommentResponse from(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userId(comment.getMember().getId())
                .postId(comment.getPost().getId())
                .build();
    }
}
