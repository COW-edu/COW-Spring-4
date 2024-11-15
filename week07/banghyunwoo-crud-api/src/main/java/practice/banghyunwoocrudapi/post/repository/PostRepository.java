package practice.banghyunwoocrudapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.banghyunwoocrudapi.post.entity.Post;

import java.util.Optional;

//@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Optional<Post> findById(Long id);
    //    private final Map<Integer, Post> boardRepository = new ConcurrentHashMap<>();
//    private int id;
//
//    public void save(Post post) {
//        ++id;
//        post.setId(id);
//        boardRepository.put(id, post);
//    }
//
//    public List<PostResponse> getAllPost() {
//        return boardRepository.entrySet().stream().map(entry -> PostResponse.from(entry.getValue())).collect(Collectors.toList());
//    }
//
//    public Post getPost(int id) {
//        return boardRepository.get(id);
//    }
//
//    public void update(Post post) {
//        boardRepository.put(post.getId(), post);
//    }
//
//    public void delete(int id) {
//        boardRepository.remove(id);
//    }

}
