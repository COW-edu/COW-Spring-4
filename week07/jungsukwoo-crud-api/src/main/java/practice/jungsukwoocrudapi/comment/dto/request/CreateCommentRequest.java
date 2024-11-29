package practice.jungsukwoocrudapi.comment.dto.request;

import lombok.Getter;
import practice.jungsukwoocrudapi.comment.entity.Comment;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.post.entity.Post;

@Getter
public class CreateCommentRequest {

    private Long userId;
    private Long postId;
    private String content;

    public Comment toEntity(Member member, Post post){
        return Comment.builder()
                .content(content)
                .member(member)
                .post(post)
                .build();
    }
}
