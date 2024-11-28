package practice.parksuehyuncrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public void save(@RequestBody CreatePostRequest createPostRequest) {
        postService.save(createPostRequest);
    }

    @GetMapping
    public List<PostResponse> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{title}")
    public PostResponse getPost(@PathVariable String title) {
        return postService.getPost(title);
    }

    @PutMapping("/{title}")
    public void update(@PathVariable String title, @RequestBody UpdatePostRequest updatePostRequest) {
        postService.update(title, updatePostRequest);
    }

    @DeleteMapping("/{title}")
    public void delete(@PathVariable String title) {
        postService.delete(title);
    }
}
