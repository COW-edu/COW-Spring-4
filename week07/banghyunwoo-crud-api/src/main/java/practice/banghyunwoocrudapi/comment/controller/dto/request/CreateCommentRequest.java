package practice.banghyunwoocrudapi.comment.controller.dto.request;

import lombok.Getter;
import practice.banghyunwoocrudapi.comment.entity.Comment;
import practice.banghyunwoocrudapi.post.entity.Post;

@Getter
public class CreateCommentRequest {
    private Long id;
    private String content;

    public Comment toEntity(Post post){
        return Comment.builder()
                .content(content)
                .post(post)
                .build();
    }
}
