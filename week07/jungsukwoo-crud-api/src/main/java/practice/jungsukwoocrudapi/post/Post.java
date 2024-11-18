package practice.jungsukwoocrudapi.post;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.jungsukwoocrudapi.member.entity.Member;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private String title;
    private String content;

@Builder
    private Post(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }
}
