package practice.seoayeongcrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.seoayeongcrudapi.post.controller.dto.request.CreatePostRequest;
import practice.seoayeongcrudapi.post.controller.dto.response.PostResponse;
import practice.seoayeongcrudapi.post.service.PostService;
import practice.seoayeongcrudapi.post.controller.dto.request.UpdatePostRequest;

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

    @DeleteMapping("/posts/{title}")
    public void deleteMember(@PathVariable("title") String title) {
        postService.deletePost(title);
    }
}