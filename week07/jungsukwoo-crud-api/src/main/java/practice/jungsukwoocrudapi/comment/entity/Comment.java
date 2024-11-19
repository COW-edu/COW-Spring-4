package practice.jungsukwoocrudapi.comment.entity;

import jakarta.persistence.*;
import lombok.Builder;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.post.entity.Post;

public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;

    @Builder
    private Comment(final String content, final Post post, final Member member) {
        this.content = content;
        this.post = post;
        this.member = member;
    }

}
