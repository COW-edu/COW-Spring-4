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
    public Post findById(String id) {
        return postRepository.get(id);
    }
    public void patch(String title, Post post) {
        postRepository.remove(title);
        postRepository.put(post.getTitle(), post);
    }
    public void delete(String title) {
        postRepository.remove(title);
    }
}
