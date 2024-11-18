package practice.jungsukwoocrudapi.post;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PostRepository {
    private final Map<String, Post> postRepository = new ConcurrentHashMap<>();
//
//    public void savePost(Post post) {
//        postRepository.put(post.getUserId(), post);
//    }
//
//    public Post readPost(String userId) {
//        return postRepository.get(userId);
//    }
//

}
