package practice.jungsukwoocrudapi.post.controller;

import lombok.RequiredArgsConstructor;
import practice.jungsukwoocrudapi.post.service.PostService;

@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

//    @PostMapping("/posts")
//    public void makePost(@RequestBody CreatePostRequest createPostRequest) {
//        postService.makePost(createPostRequest);
//    }

}
