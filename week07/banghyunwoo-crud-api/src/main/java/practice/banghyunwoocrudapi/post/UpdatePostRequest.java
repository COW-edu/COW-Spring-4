package practice.banghyunwoocrudapi.post;

import lombok.Getter;

@Getter
public class UpdatePostRequest {
    private String title;
    private String content;
    private Integer userId;

    public Post getPost(Post post, UpdatePostRequest updatePostRequest) {
        return post.toBuilder()
                .title(updatePostRequest.title != null ? updatePostRequest.getTitle() : post.getTitle())
                .content(updatePostRequest.content != null ? updatePostRequest.getContent() : post.getContent())
                .userId(updatePostRequest.userId != null ? updatePostRequest.getUserId() : post.getUserId())
                .build();
    }
}
