package practice.jungsukwoocrudapi.post.repository;

import org.springframework.stereotype.Repository;
import practice.jungsukwoocrudapi.post.entity.Post;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PostRepository {
    private final Map<String, Post> postRepository = new ConcurrentHashMap<>();

}
