package practice.banghyunwoocrudapi.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.banghyunwoocrudapi.member.entity.Member;
import practice.banghyunwoocrudapi.member.repository.MemberJpaRepository;
import practice.banghyunwoocrudapi.post.controller.dto.request.CreatePostRequest;
import practice.banghyunwoocrudapi.post.controller.dto.request.UpdatePostRequest;
import practice.banghyunwoocrudapi.post.controller.dto.response.PostResponse;
import practice.banghyunwoocrudapi.post.entity.Post;
import practice.banghyunwoocrudapi.post.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final MemberJpaRepository memberJpaRepository;
    private final PostRepository postRepository;

    public void createPost(CreatePostRequest createPostRequest) {
        Member member = memberJpaRepository.findById(createPostRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 이름으로 member를 찾을 수 없습니다."));
        Post post = createPostRequest.toEntity(member);
        postRepository.save(post);
    }
    @Transactional(readOnly = true)
    public List<PostResponse> getAllPost() {
        return postRepository.findAll().stream()
                .map(post -> PostResponse.from(post))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.getReferenceById(id);
        return PostResponse.from(post);
    }

    public void update(Long id, UpdatePostRequest updatePostRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID로 POST를 찾을 수 없습니다."));
        post.update(updatePostRequest);
    }

    public void delete(Long id) {
        Post deletePost = postRepository.getReferenceById(id);
        postRepository.delete(deletePost);
    }

    public List<PostResponse> getByUserID(Long userId) {
        return postRepository.findByMemberId(userId).stream()
                .map(post -> PostResponse.from(post))
                .collect(Collectors.toList());
    }
}
