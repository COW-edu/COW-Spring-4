package com.example.junhyukcrudapi.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Long addComment(Long postId, CreateCommentRequest createCommentRequest) {
        Comment comment = Comment.builder()
                .content(createCommentRequest.getContent())
                .userId(createCommentRequest.getUserId())
                .postId(postId)
                .build();
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void updateComment(Long id, String newContent) {
        Comment comment = commentRepository.findById(id);
        comment.updateContent(newContent);
        commentRepository.update(id, newContent);
    }

    public void deleteComment(Long id) {
        commentRepository.delete(id);
    }
}
