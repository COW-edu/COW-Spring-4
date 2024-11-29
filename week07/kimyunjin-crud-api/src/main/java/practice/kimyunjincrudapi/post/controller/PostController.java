package practice.kimyunjincrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.kimyunjincrudapi.post.Post;
import practice.kimyunjincrudapi.post.controller.dto.CreatePostRequest;
import practice.kimyunjincrudapi.post.controller.dto.UpdatePostRequest;
import practice.kimyunjincrudapi.post.service.PostService;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public Post createPost(@RequestBody CreatePostRequest createPostRequest) {
        return postService.createPost(createPostRequest);
    }

    @GetMapping("/posts")
    public Collection<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody UpdatePostRequest updatePostRequest) {
        return postService.updatePost(id, updatePostRequest);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/posts")
    public ResponseEntity<Void> deleteAllPosts() {
        postService.deleteAllPosts();
        return ResponseEntity.noContent().build();
    }
}
