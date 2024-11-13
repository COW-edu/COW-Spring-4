package practice.kimyunjincrudapi.comment;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {

    private final Map<Long, Comment> commentRepository = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Comment save(Comment comment) {
        commentRepository.put(comment.getId(), comment);
        return comment;
    }

    public Long generateId() {
        return idGenerator.getAndIncrement();
    }

    public List<Comment> findByPostId(Long postId) {
        return commentRepository.values().stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .collect(Collectors.toList());
    }

    public Collection<Comment> findAll() {
        return commentRepository.values();
    }

    public Comment findById(Long commentId) {
        return commentRepository.get(commentId);
    }

    public void deleteById(Long commentId) {
        commentRepository.remove(commentId);
    }

    public void deleteAll() {
        commentRepository.clear();
    }
}
