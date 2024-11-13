package practice.kimsioncrudapi.post;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public void writePost(CreatePostRequest createPostRequest) {
    Post post = createPostRequest.toEntity();
    postRepository.save(post);
  }

  public List<PostResponse> getPosts() {
    return postRepository.getAllPost();
  }

  public PostResponse getPost(Integer id) {
    Post post = postRepository.findById(id);
    return PostResponse.from(post);
  }

  public PostResponse updatePost(Integer id, CreatePostRequest createPostRequest) {
    Post post = postRepository.findById(id);
    post.update(createPostRequest);
    postRepository.update(post);
    return PostResponse.from(post);
  }

  public void deletePost(Integer id) {
    postRepository.delete(id);
  }

}
