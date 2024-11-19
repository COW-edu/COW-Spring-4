package practice.seoayeongcrudapi.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.seoayeongcrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.seoayeongcrudapi.member.controller.dto.response.MemberResponse;
import practice.seoayeongcrudapi.member.entity.Member;
import practice.seoayeongcrudapi.post.controller.dto.request.UpdatePostRequest;
import practice.seoayeongcrudapi.post.controller.dto.request.CreatePostRequest;
import practice.seoayeongcrudapi.post.controller.dto.response.PostResponse;
import practice.seoayeongcrudapi.post.entity.Post;
import practice.seoayeongcrudapi.post.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void uploadPost(CreatePostRequest createPostRequest) {
        Post post = createPostRequest.toEntity();
        postRepository.save(post);
    }

    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Post를 찾을 수 없습니다."));
        return PostResponse.from(post);
    }

    public List<PostResponse> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(PostResponse.from(post));
        }
        return postResponses;
    }
    public void updatePost(Long id, UpdatePostRequest updatePostRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post를 찾을 수 없습니다. ID: " + id));
        post.update(updatePostRequest.getTitle(), updatePostRequest.getContent());
    }
    public void deletePost(String title) {
        postRepository.delete(title);
    }

}