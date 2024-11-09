package cow.hoya_jpa_crud.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cow.hoya_jpa_crud.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
