package practice.jungsukwoocrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.jungsukwoocrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.jungsukwoocrudapi.member.controller.dto.response.MemberResponse;
import practice.jungsukwoocrudapi.post.controller.dto.request.CreatePostRequest;
import practice.jungsukwoocrudapi.post.controller.dto.request.UpdatePostRequest;
import practice.jungsukwoocrudapi.post.controller.dto.response.PostResponse;
import practice.jungsukwoocrudapi.post.service.PostService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping()
    public void postUp(@RequestBody CreatePostRequest createPostRequest) {
        postService.postUp(createPostRequest);
    }

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public void updatePostById(@PathVariable("id") Long id, @RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePostById(id, updatePostRequest);
    }
}
