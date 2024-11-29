package practice.seoayeongcrudapi.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.seoayeongcrudapi.member.entity.Member;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Post(final String title, final String content, final Member member, final String userId) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.userId = userId;
    }

    public static Post from(final String title, final String content, final Member member) {
        return Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}