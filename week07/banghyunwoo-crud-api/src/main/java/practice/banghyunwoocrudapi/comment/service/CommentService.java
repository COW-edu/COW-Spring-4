package practice.banghyunwoocrudapi.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.banghyunwoocrudapi.comment.controller.dto.request.CreateCommentRequest;
import practice.banghyunwoocrudapi.comment.controller.dto.response.CommentResponse;
import practice.banghyunwoocrudapi.comment.entity.Comment;
import practice.banghyunwoocrudapi.comment.repository.CommentRepository;
import practice.banghyunwoocrudapi.post.entity.Post;
import practice.banghyunwoocrudapi.post.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void create(CreateCommentRequest createCommentRequest) {
        Post post = postRepository.findById(createCommentRequest.getId())
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 ID입니다."));
        Comment comment = createCommentRequest.toEntity(post);
        commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> getAll() {
        List<CommentResponse> commentResponses = new ArrayList<>();
        List<Comment> comments = commentRepository.findAll();
        for (Comment comment : comments) {
            commentResponses.add(CommentResponse.from(comment));
        }
        return commentResponses;

    }
}
