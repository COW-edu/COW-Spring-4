package practice.kimyunjincrudapi.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public Comment createComment(@RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.createComment(createCommentRequest);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> findCommentsByPostId(@PathVariable Long postId) {
        return commentService.findCommentsByPostId(postId);
    } // postId로 post 전체의 comment 가져오기

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.findCommentById(commentId);
        return ResponseEntity.ok(comment);
    } // 특정 comment 가져오기(commentId로)

    @GetMapping("/comments")
    public Collection<Comment> findAllComments() {
        return commentService.findAllComments();
    } // 전체 comment 가져오기

    @PutMapping("/comments/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest updateCommentRequest) {
        return commentService.updateComment(commentId, updateCommentRequest);
    } // commentId로 comment 수정하기

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/comments")
    public ResponseEntity<Void> deleteAllComments() {
        commentService.deleteAllComments();
        return ResponseEntity.noContent().build();
    }
}
