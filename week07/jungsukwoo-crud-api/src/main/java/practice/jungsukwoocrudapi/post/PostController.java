package practice.jungsukwoocrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

//    @PostMapping("/posts")
//    public void makePost(@RequestBody CreatePostRequest createPostRequest) {
//        postService.makePost(createPostRequest);
//    }

}
