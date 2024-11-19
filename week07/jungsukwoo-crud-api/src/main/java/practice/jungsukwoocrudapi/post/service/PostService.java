package practice.jungsukwoocrudapi.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.jungsukwoocrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.member.repository.MemberRepository;
import practice.jungsukwoocrudapi.post.controller.dto.request.CreatePostRequest;
import practice.jungsukwoocrudapi.post.entity.Post;
import practice.jungsukwoocrudapi.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public void postUp(CreatePostRequest createPostRequest) {
        Member member = memberRepository.findById(createPostRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Member를 찾을 수 없습니다."));
        Post post = createPostRequest.toEntity(member);
        postRepository.save(post);
    }


}
