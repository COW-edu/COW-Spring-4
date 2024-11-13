package practice.seoayeongcrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.seoayeongcrudapi.member.UpdateMemberRequest;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void uploadPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.uploadPost(createPostRequest);
    }

    @GetMapping("/posts/{title}")
    public PostResponse getPost(@PathVariable("title") String title) {
        return postService.getPost(title);
    }

    @PutMapping("/posts/{title}")
    public void updatePost(@RequestBody UpdatePostRequest updatePostemberRequest, @PathVariable("title") String title) {
        postService.updatePost(title, updatePostemberRequest);
    }
}