package practice.banghyunwoocrudapi.post.controller.dto.request;

import lombok.Getter;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.post.entity.Post;

@Getter
public class CreatePostRequest {
    private Long userId;
    private String title;
    private String content;

    public Post toEntity(Member member) {
        return Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
