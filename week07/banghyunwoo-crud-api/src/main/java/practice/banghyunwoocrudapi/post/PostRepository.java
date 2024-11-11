package practice.banghyunwoocrudapi.post;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PostRepository {
    private final Map<Integer, Post> boardRepository = new ConcurrentHashMap<>();
    private int id;

    public void save(Post post) {
        ++id;
        post.setId(id);
        boardRepository.put(id, post);
    }

    public List<PostResponse> getAllPost() {
        return boardRepository.entrySet().stream().map(entry -> PostResponse.from(entry.getValue())).collect(Collectors.toList());
    }

    public Post getPost(int id) {
        return boardRepository.get(id);
    }

    public void update(Post post) {
        boardRepository.put(post.getId(), post);
    }

    public void delete(int id) {
        boardRepository.remove(id);
    }
}
