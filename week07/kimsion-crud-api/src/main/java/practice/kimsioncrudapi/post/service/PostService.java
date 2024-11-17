package practice.kimsioncrudapi.post.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.kimsioncrudapi.member.entity.Member;
import practice.kimsioncrudapi.member.repository.MemberJpaRepository;
import practice.kimsioncrudapi.post.repository.PostJpaRepository;
import practice.kimsioncrudapi.post.controller.dto.request.CreatePostRequest;
import practice.kimsioncrudapi.post.controller.dto.response.PostResponse;
import practice.kimsioncrudapi.post.entity.Post;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

  private final PostJpaRepository postJpaRepository;
  private final MemberJpaRepository memberJpaRepository;

  public void createPost(CreatePostRequest createPostRequest) {
    Member member = memberJpaRepository.findById(createPostRequest.getMemberId())
        .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다."));
    Post post = createPostRequest.toEntity(member);
    postJpaRepository.save(post);
  }

  @Transactional(readOnly = true)
  public List<PostResponse> getPosts() {
    List<Post> posts = postJpaRepository.findAll();
    return posts.stream()
        .map(PostResponse::from)
        .toList();
  }

  @Transactional(readOnly = true)
  public PostResponse getPost(Long id) {
    Post post = findById(id);
    return PostResponse.from(post);
  }

  public void updatePost(Long id, CreatePostRequest createPostRequest) {
    Post post = findById(id);
    post.update(createPostRequest);
  }

  public void deletePost(Long id) {
    Post post = findById(id);
    postJpaRepository.delete(post);
  }

  private Post findById(Long id) {
    return postJpaRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
  }

}
