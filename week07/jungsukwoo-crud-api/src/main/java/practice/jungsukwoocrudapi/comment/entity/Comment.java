package practice.jungsukwoocrudapi.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.post.entity.Post;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public static Comment from(final String content, final Post post, final Member member){
        return Comment.builder()
                .content(content)
                .post(post)
                .member(member)
                .build();
    }

}
