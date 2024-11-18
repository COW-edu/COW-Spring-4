package practice.jungsukwoocrudapi.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.jungsukwoocrudapi.member.entity.Member;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Post(final String title, final String content, final Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public static Post from(final String title, final String content, final Member member){
        return Post.builder()
            .title
            .content(content)
            .member(member)
            .build();
    }
}
