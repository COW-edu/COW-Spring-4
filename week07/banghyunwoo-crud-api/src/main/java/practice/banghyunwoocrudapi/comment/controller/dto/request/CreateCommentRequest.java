package practice.banghyunwoocrudapi.comment.controller.dto.request;

import lombok.Getter;
import practice.banghyunwoocrudapi.comment.entity.Comment;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.post.entity.Post;

@Getter
public class CreateCommentRequest {
    private Long userId;
    private String content;

    public Comment toEntity(Post post, Member member){
        return Comment.builder()
                .content(content)
                .member(member)
                .post(post)
                .build();
    }
}
