package com.example.junhyukcrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    @GetMapping("/posts")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public PostResponse getPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(id, updatePostRequest);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

}
