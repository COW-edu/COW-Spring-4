package practice.kimyunjincrudapi.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.kimyunjincrudapi.post.Post;
import practice.kimyunjincrudapi.post.controller.dto.CreatePostRequest;
import practice.kimyunjincrudapi.post.controller.dto.UpdatePostRequest;
import practice.kimyunjincrudapi.post.repository.PostRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(CreatePostRequest createPostRequest) {
        Long postId = postRepository.generateId();
        Post post = createPostRequest.toEntity(postId);
        return postRepository.save(post);
    }

    public Collection<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(Long id) {
        Post post = postRepository.findById(id);
        return post;
    }

    public Post updatePost(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id);
        post.update(request.getTitle(), request.getContent());
        return post;
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id);
        postRepository.deleteById(id);
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }
}
