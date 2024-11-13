package practice.kimsioncrudapi.post;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

  private final Map<Integer, Post> postRepository = new ConcurrentHashMap<>();
  int id = 0;

  public void save(Post post) {
    ++id;
    post.setId(id);
    postRepository.put(id, post);
  }

    public List<PostResponse> getAllPost() {
    return postRepository.values().stream().map(PostResponse::from).toList();
  }

  public Post findById(Integer id) {
    return postRepository.get(id);
  }

  public void update(Post post) {
    postRepository.put(post.getId(), post);
  }

  public void delete(Integer id) {
    postRepository.remove(id);
  }

}
