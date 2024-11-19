package practice.jungsukwoocrudapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jungsukwoocrudapi.post.entity.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long Id);
}
