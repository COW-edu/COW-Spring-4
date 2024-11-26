package practice.seoayeongcrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.seoayeongcrudapi.post.controller.dto.request.CreatePostRequest;
import practice.seoayeongcrudapi.post.controller.dto.response.PostResponse;
import practice.seoayeongcrudapi.post.service.PostService;
import practice.seoayeongcrudapi.post.controller.dto.request.UpdatePostRequest;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping()
    public void uploadPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.uploadPost(createPostRequest);
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }
    @GetMapping()
    public List<PostResponse> getPost() {
        return postService.getPosts();
    }

    @PutMapping("/{id}")
    public void updatePost(@RequestBody UpdatePostRequest updatePostRequest, @PathVariable("id") Long id) {
        postService.updatePost(id, updatePostRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}