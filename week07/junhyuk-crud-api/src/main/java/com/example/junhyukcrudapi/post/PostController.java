package com.example.junhyukcrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public Long createPost(@RequestBody CreatePostRequest createPostRequest) {
        return postService.createPost(createPostRequest);
    }

    @GetMapping("/posts")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }
}
