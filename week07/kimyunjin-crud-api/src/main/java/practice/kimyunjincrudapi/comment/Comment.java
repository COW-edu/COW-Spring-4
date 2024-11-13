package practice.kimyunjincrudapi.comment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Comment {

    private Long id;
    private Long postId;  // 댓글이 달린 게시글의 ID
    private String content;
    private Long userId;

    @Builder
    public Comment(Long id, Long postId, String content, Long userId) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.userId = userId;
    }

    public void updateContent(String newContent) {
        this.content = newContent;
    }
}
