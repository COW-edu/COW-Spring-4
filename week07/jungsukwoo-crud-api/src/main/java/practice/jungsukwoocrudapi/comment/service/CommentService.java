package practice.jungsukwoocrudapi.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.jungsukwoocrudapi.comment.dto.request.CreateCommentRequest;
import practice.jungsukwoocrudapi.comment.dto.response.CommentResponse;
import practice.jungsukwoocrudapi.comment.entity.Comment;
import practice.jungsukwoocrudapi.comment.repository.CommentRepository;
import practice.jungsukwoocrudapi.member.entity.Member;
import practice.jungsukwoocrudapi.member.repository.MemberRepository;
import practice.jungsukwoocrudapi.post.entity.Post;
import practice.jungsukwoocrudapi.post.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    public void commentUp(CreateCommentRequest createCommentRequest){
        Member member = memberRepository.findById(createCommentRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Member를 찾을 수 없습니다."));

        Post post = postRepository.findById(createCommentRequest.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("Post를 찾을 수 없습니다."));

        Comment comment = createCommentRequest.toEntity(member, post);
        commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> getCommentsByPostId(final Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(CommentResponse::from)
                .collect(Collectors.toList());
    }
}
