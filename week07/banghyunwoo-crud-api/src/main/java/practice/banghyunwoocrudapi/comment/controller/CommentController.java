package practice.banghyunwoocrudapi.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.banghyunwoocrudapi.comment.controller.dto.request.CreateCommentRequest;
import practice.banghyunwoocrudapi.comment.controller.dto.response.CommentResponse;
import practice.banghyunwoocrudapi.comment.repository.CommentRepository;
import practice.banghyunwoocrudapi.comment.service.CommentService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public void create(@RequestBody CreateCommentRequest createCommentRequest){
        commentService.create(createCommentRequest);
    }

    @GetMapping
    public List<CommentResponse> getAllComment(){
        return commentService.getAll();
    }
}
