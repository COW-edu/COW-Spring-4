package com.example.junhyukcrudapi.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public Long addComment(@PathVariable("postId") Long postId, @RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.addComment(postId, createCommentRequest);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable("postId") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public void updateComment(@PathVariable("id") Long id, @RequestBody UpdateCommentRequest updateCommentRequest, @PathVariable("postId") Long postId) {
        commentService.updateComment(id, updateCommentRequest.getContent());
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public void deleteComment(@PathVariable("id") Long id, @PathVariable("postId") Long postId) {
        commentService.deleteComment(id);
    }
}