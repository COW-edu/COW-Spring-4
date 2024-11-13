package practice.kimyunjincrudapi.post;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {

    private final Map<Long, Post> postRepository = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Post save(Post post) {
        postRepository.put(post.getId(), post);
        return post;
    }

    public Long generateId() {
        return idGenerator.getAndIncrement();
    }

    public Collection<Post> findAll() {
        return postRepository.values();
    }

    public Post findById(Long id) {
        return postRepository.get(id);
    }

    public void deleteById(Long id) {
        postRepository.remove(id);
    }

    public void deleteAll() {
        postRepository.clear();
    }
}
