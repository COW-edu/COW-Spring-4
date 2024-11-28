package practice.seoayeongcrudapi.post.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.seoayeongcrudapi.member.entity.Member;
import practice.seoayeongcrudapi.post.entity.Post;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);

}
