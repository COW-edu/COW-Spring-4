package practice.banghyunwoocrudapi.comment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.banghyunwoocrudapi.comment.controller.dto.response.CommentResponse;
import practice.banghyunwoocrudapi.comment.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(Long postId);

    List<Comment> findByMemberId(Long userId);
}
