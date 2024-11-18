package practice.jungsukwoocrudapi.post;

import lombok.Getter;

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
