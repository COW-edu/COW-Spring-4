package practice.jungsukwoocrudapi.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jungsukwoocrudapi.comment.entity.Comment;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findbyId(Long id);
}
