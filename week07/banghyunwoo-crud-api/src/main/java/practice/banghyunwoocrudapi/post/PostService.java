package practice.banghyunwoocrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(CreatePostRequest createPostRequest) {
        Post post = createPostRequest.toEntity();
        postRepository.save(post);
    }

    public List<PostResponse> getAllPost() {
        return postRepository.getAllPost();
    }

    public PostResponse getPost(int id) {
        Post post = postRepository.getPost(id);
        return PostResponse.from(post);
    }

    public void updatePost(int id, UpdatePostRequest updatePostRequest) {
        Post post = postRepository.getPost(id);
        Post updatepost = updatePostRequest.getPost(post, updatePostRequest);
        postRepository.update(updatepost);
    }

    public void deletePost(int id) {
        postRepository.delete(id);
    }
}
