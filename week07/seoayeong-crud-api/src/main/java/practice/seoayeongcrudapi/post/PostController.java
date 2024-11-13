package practice.seoayeongcrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.seoayeongcrudapi.member.MemberResponse;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/members")
    public void uploadPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.uploadPost(createPostRequest);
    }

    @GetMapping("/members/{name}")
    public PostResponse getPost(@PathVariable("name") String name) {
        return postService.getPost(name);
    }

}