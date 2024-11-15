package practice.banghyunwoocrudapi.comment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.banghyunwoocrudapi.comment.entity.Comment;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Override
    Optional<Comment> findById(Long Id);
}
