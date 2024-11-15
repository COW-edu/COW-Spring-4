package practice.banghyunwoocrudapi.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.banghyunwoocrudapi.comment.controller.dto.request.CreateCommentRequest;
import practice.banghyunwoocrudapi.comment.controller.dto.response.CommentResponse;
import practice.banghyunwoocrudapi.comment.service.CommentService;
import practice.banghyunwoocrudapi.member.entity.Member;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}")
    public void create(@PathVariable Long id,
                       @RequestBody CreateCommentRequest createCommentRequest){
        commentService.create(id,createCommentRequest,createCommentRequest.getUserId());
    }

    @GetMapping("/{id}")
    public List<CommentResponse> getComments(@PathVariable Long id){
        return commentService.getComments(id);
    }

//    @GetMapping("/{id}")
//    public CommentResponse getComment(@PathVariable Long id){
//        return commentService.getComment(id);
//    }
}
