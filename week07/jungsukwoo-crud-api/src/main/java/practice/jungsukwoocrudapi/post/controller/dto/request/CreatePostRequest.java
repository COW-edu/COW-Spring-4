package practice.jungsukwoocrudapi.post.controller.dto.request;

import lombok.Getter;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.post.entity.Post;

@Getter
public class CreatePostRequest {

    private Long userId;
    private String title;
    private String content;

    public Post toEntity(Member member){
        return Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
