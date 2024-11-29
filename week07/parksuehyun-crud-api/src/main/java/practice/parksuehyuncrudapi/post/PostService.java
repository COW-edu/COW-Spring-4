package practice.parksuehyuncrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Component
public class PostService {
    private final PostRepository postRepository;

    public void save(CreatePostRequest createPostRequest) {
        Post post = createPostRequest.toEntity();
        postRepository.save(post);
    }

    public List<PostResponse> getAll() {
        return postRepository.getAll().stream()
                .map(PostResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public PostResponse getPost(String title) {
        Post post = postRepository.getPost(title);
        return PostResponse.fromEntity(post);
    }

    public void update(String title, UpdatePostRequest updatePostRequest) {
        Post post = postRepository.getPost(title);
        post.update(updatePostRequest.getTitle(), updatePostRequest.getContent());
        postRepository.update(post);
    }

    public void delete(String title) {
        postRepository.delete(title);
    }
}