package practice.banghyunwoocrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostRequest createPostRequest) {
        ;
        postService.createPost(createPostRequest);
    }

    @GetMapping("/posts")
    public List<PostResponse> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/posts/{id}")
    public PostResponse getPost(@PathVariable int id) {
        return postService.getPost(id);
    }

    @PutMapping("/posts/update/{id}")
    public void updatePost(@PathVariable int id,
                           @RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(id, updatePostRequest);
    }

    @DeleteMapping("/posts/delete/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
}
