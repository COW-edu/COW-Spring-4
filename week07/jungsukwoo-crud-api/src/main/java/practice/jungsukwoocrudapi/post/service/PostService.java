package practice.jungsukwoocrudapi.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jungsukwoocrudapi.post.repository.PostRepository;

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
