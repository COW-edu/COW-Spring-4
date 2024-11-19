package practice.jungsukwoocrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.jungsukwoocrudapi.post.controller.dto.request.CreatePostRequest;
import practice.jungsukwoocrudapi.post.service.PostService;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping()
    public void postUp(@RequestBody CreatePostRequest createPostRequest) {
        postService.postUp(createPostRequest);
    }

}
