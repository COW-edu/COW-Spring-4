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
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    @GetMapping("/posts")
    public List<PostResponse> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/posts/{id}")
    public PostResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/users/{userId}/posts")
    public List<PostResponse> getUserPost(@PathVariable Long userId){
        return postService.getByUserID(userId);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable Long id,
                           @RequestBody UpdatePostRequest updatePostRequest) {
        postService.update(id, updatePostRequest);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }
}
