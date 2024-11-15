package practice.banghyunwoocrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.banghyunwoocrudapi.post.controller.dto.request.CreatePostRequest;
import practice.banghyunwoocrudapi.post.controller.dto.response.PostResponse;
import practice.banghyunwoocrudapi.post.service.PostService;
import practice.banghyunwoocrudapi.post.controller.dto.request.UpdatePostRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public void createPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    @GetMapping
    public List<PostResponse> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id,
                           @RequestBody UpdatePostRequest updatePostRequest) {
        postService.update(id, updatePostRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }
}
