package practice.kimsioncrudapi.post;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @PostMapping("/posts")
  public void writePost(@RequestBody CreatePostRequest createPostRequest){
    postService.writePost(createPostRequest);
  }

  @GetMapping("/posts")
  public List<PostResponse> getPosts(){
    return postService.getPosts();
  }

  @GetMapping("/posts/{id}")
  public PostResponse getPost(@PathVariable Integer id){
    return postService.getPost(id);
  }

  @PatchMapping("/posts/{id}")
  public void updatePost(@PathVariable Integer id, @RequestBody CreatePostRequest createPostRequest){
    postService.updatePost(id, createPostRequest);
  }

  @DeleteMapping("/posts/{id}")
  public void deletePost(@PathVariable Integer id){
    postService.deletePost(id);
  }

}
