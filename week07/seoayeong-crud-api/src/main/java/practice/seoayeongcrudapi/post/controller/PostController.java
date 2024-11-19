package practice.seoayeongcrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.seoayeongcrudapi.post.controller.dto.request.CreatePostRequest;
import practice.seoayeongcrudapi.post.controller.dto.response.PostResponse;
import practice.seoayeongcrudapi.post.service.PostService;
import practice.seoayeongcrudapi.post.controller.dto.request.UpdatePostRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void uploadPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.uploadPost(createPostRequest);
    }

    @GetMapping("/posts/{id}")
    public PostResponse getPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }
    @GetMapping("/posts")
    public List<PostResponse> getPost() {
        return postService.getPosts();
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@RequestBody UpdatePostRequest updatePostRequest, @PathVariable("id") Long id) {
        postService.updatePost(id, updatePostRequest);
    }

    @DeleteMapping("/posts/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}