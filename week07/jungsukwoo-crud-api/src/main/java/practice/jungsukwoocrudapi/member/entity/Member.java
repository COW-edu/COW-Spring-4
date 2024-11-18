package practice.jungsukwoocrudapi.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.jungsukwoocrudapi.post.Post;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    private static long idCounter = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "member", orphanRemoval = true)
    List<Post> posts = new ArrayList<>();

    @Builder
    private Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Member from(String name) {
        return Member.builder()
                .name(name)
                .build();
    }

    public void updateInfo(String name, String email, String password){
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
        if (password != null && !password.isEmpty()) {
            this.password = password;
        }
    }
}
