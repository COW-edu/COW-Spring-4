package practice.banghyunwoocrudapi.post.entity;

import jakarta.persistence.*;
import lombok.*;
import practice.banghyunwoocrudapi.comment.entity.Comment;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.post.controller.dto.request.UpdatePostRequest;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(final String title, final String content, final Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void update(UpdatePostRequest updatePost) {
        this.content = updatePost.getContent();
        this.title = updatePost.getTitle();
    }

}
