package practice.banghyunwoocrudapi.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.banghyunwoocrudapi.comment.controller.dto.request.UpdateCommentRequest;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.post.entity.Post;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @Builder
    public Comment(final String content, final Post post, final Member member) {
        this.content = content;
        this.post = post;
        this.member = member;
    }

    public void update(UpdateCommentRequest updateCommentRequest) {
        this.content = updateCommentRequest.getContent();
    }
}
