package practice.kimsioncrudapi.post.controller.dto;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.kimsioncrudapi.post.controller.dto.request.CreatePostRequest;
import practice.kimsioncrudapi.post.controller.dto.response.PostResponse;
import practice.kimsioncrudapi.post.service.PostService;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @PostMapping("/posts")
  public void writePost(@RequestBody CreatePostRequest createPostRequest){
    postService.createPost(createPostRequest);
  }

  @GetMapping("/posts")
  public List<PostResponse> getPosts(){
    return postService.getPosts();
  }

  @GetMapping("/posts/{id}")
  public PostResponse getPost(@PathVariable Long id){
    return postService.getPost(id);
  }

  @PatchMapping("/posts/{id}")
  public void updatePost(@PathVariable("id") Long id, @RequestBody CreatePostRequest createPostRequest){
    postService.updatePost(id, createPostRequest);
  }

  @DeleteMapping("/posts/{id}")
  public void deletePost(@PathVariable Long id){
    postService.deletePost(id);
  }

}
