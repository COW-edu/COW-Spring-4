package practice.parksuehyuncrudapi.post;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PostRepository {
    private final Map<String, Post> postRepository = new ConcurrentHashMap<>();

    public void save(Post post) {
        postRepository.put(post.getTitle(), post);
    }

    public List<Post> getAll() {
        return new ArrayList<>(postRepository.values());
    }

    public Post getPost(String title) {
        return postRepository.get(title);
    }

    public void update(Post post) {
        postRepository.put(post.getTitle(), post);
    }

    public void delete(String title) {
        postRepository.remove(title);
    }
}
