package practice.banghyunwoocrudapi.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.banghyunwoocrudapi.comment.controller.dto.request.CreateCommentRequest;
import practice.banghyunwoocrudapi.comment.controller.dto.request.UpdateCommentRequest;
import practice.banghyunwoocrudapi.comment.controller.dto.response.CommentResponse;
import practice.banghyunwoocrudapi.comment.service.CommentService;
import practice.banghyunwoocrudapi.member.entity.Member;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}")
    public void create(@PathVariable Long postId,
                       @RequestBody CreateCommentRequest createCommentRequest){
        commentService.create(postId,createCommentRequest);
    }

    @GetMapping("/{postId}")
    public List<CommentResponse> getComments(@PathVariable Long postId){
        return commentService.getComments(postId);
    }

    @PutMapping("/{id}")
    public void getComment(@PathVariable Long id,
                           @RequestBody UpdateCommentRequest updateCommentRequest){
        commentService.update(id, updateCommentRequest);
    }
}
