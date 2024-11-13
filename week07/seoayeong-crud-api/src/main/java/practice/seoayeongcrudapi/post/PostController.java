package practice.seoayeongcrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/members")
    public void uploadPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.uploadPost(createPostRequest);
    }

}