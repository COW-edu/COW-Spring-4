package practice.jungsukwoocrudapi.post.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import practice.jungsukwoocrudapi.post.entity.Post;

@Getter
@Builder
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private Long userId;

    public static PostResponse from(Post post){
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .userId(post.getMember().getId())
                .build();
    }
}
