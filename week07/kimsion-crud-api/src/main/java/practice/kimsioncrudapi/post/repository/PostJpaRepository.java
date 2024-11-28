package practice.kimsioncrudapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.kimsioncrudapi.post.entity.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

}
