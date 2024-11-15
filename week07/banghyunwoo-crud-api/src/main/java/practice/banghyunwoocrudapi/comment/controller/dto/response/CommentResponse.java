package practice.banghyunwoocrudapi.comment.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.banghyunwoocrudapi.comment.entity.Comment;
import practice.banghyunwoocrudapi.comment.repository.CommentRepository;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.post.entity.Post;

@Getter
public class CommentResponse {
    private Long id;
    private String content;
    private Long userId;
    private Long postId;

    @Builder
    public CommentResponse(Long id, String content, Long userId, Long postId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }

    public static CommentResponse from(Comment comment){
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userId(comment.getMember().getId())
                .postId(comment.getPost().getId())
                .build();
    }
}
