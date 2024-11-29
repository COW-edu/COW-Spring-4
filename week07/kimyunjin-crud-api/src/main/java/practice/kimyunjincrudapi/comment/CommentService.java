package practice.kimyunjincrudapi.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment createComment(CreateCommentRequest createCommentRequest) {
        Long commentId = commentRepository.generateId();
        Comment comment = createCommentRequest.toEntity(commentId);
        return commentRepository.save(comment);
    }

    public List<Comment> findCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Collection<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public Comment updateComment(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId);
        comment.updateContent(request.getContent());
        return comment;
    }

    public void deleteCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId);
        commentRepository.deleteById(commentId);
    }

    public void deleteAllComments() {
        commentRepository.deleteAll();
    }
}
