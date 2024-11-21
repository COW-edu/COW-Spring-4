package practice.jungsukwoocrudapi.comment.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.jungsukwoocrudapi.comment.dto.request.CreateCommentRequest;
import practice.jungsukwoocrudapi.comment.dto.response.CommentResponse;
import practice.jungsukwoocrudapi.comment.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping()
    public void commentUp(@RequestBody CreateCommentRequest createCommentRequest){
        commentService.commentUp(createCommentRequest);
    }

    @GetMapping("/post/{postId}")
    public List<CommentResponse> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        commentService.deleteCommentById(id);
    }

}
