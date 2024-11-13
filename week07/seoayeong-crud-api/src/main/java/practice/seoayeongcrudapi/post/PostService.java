package practice.seoayeongcrudapi.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.seoayeongcrudapi.member.Member;
import practice.seoayeongcrudapi.member.UpdateMemberRequest;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void uploadPost(CreatePostRequest createPostRequest) {
        Post post = createPostRequest.toEntity();
        postRepository.upload(post);
    }
    public PostResponse getPost(String id) {
        Post post = postRepository.findById(id);
        return PostResponse.from(post);
    }
    public void updatePost(String title, UpdatePostRequest updatePostRequest) {
        Post post = updatePostRequest.toEntity();
        postRepository.patch(title, post);
    }

}