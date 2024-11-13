package practice.seoayeongcrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.seoayeongcrudapi.member.*;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void uploadPost(CreatePostRequest createPostRequest) {
        Post post = createPostRequest.toEntity();
        postRepository.upload(post);
    }
}