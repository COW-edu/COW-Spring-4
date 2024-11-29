package practice.kimyunjincrudapi.comment;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private Long postId;  // 댓글이 달린 게시글 ID
    private String content;
    private Long userId;

    public Comment toEntity(Long commentId) {
        return Comment.builder()
                .id(commentId)
                .postId(postId)
                .content(content)
                .userId(userId)
                .build();
    }
}
