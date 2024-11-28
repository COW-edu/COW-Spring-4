package com.example.junhyukcrudapi.comment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CommentRepository {

    private final Map<Long, Comment> commentRepository = new ConcurrentHashMap<>();
    private static Long id = 0L;

    public Long save(Comment comment) {
        id++;
        comment = Comment.builder()
                .id(id)
                .content(comment.getContent())
                .userId(comment.getUserId())
                .postId(comment.getPostId())
                .build();
        commentRepository.put(id, comment);
        return id;
    }

    public List<Comment> findByPostId(Long postId) {
        List<Comment> commentsOfPost = new ArrayList<>();
        for (Comment comment : commentRepository.values()) {
            commentsOfPost.add(comment);
        }
        return commentsOfPost;
    }

    public Comment findById(Long id) {
        return commentRepository.get(id);
    }

    public void update(Long id, String newContent) {
        Comment comment = commentRepository.get(id);
        comment.updateContent(newContent);
    }

    public void delete(Long id) {
        commentRepository.remove(id);
    }
}
