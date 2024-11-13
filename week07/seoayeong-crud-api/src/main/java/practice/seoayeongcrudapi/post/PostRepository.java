package practice.seoayeongcrudapi.post;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PostRepository {
    private final Map<String, Post> postRepository = new ConcurrentHashMap<>();

    public void upload(Post post) {
        postRepository.put(post.getTitle(), post);
    }
}
