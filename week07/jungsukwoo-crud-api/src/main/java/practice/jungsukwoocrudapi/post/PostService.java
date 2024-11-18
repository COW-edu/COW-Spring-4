package practice.jungsukwoocrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

//    public void makePost(CreatePostRequest createPostRequest) {
//        Post post = createPostRequest.toEntity();
//        postRepository.savePost(post);
//    }
//
//    public PostResponse readPost(String userId) {
//        Post post = postRepository.readPost(userId);
//    }
}
