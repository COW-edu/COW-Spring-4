package practice.jungsukwoocrudapi.post.controller.dto.request;

import lombok.Getter;
import practice.jungsukwoocrudapi.post.entity.Post;

@Getter
public class CreatePostRequest {

//    private int id;
//    private String userId;
    private String title;
    private String content;

    public Post toEntity(){
        return Post.builder()
//                .id(id)
//                .userId(userId)
                .title(title)
                .content(content)
                .build();
    }
}
