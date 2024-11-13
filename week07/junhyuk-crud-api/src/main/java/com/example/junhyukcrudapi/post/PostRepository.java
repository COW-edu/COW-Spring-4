package com.example.junhyukcrudapi.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    private final Map<Long, Post> postRepository = new ConcurrentHashMap<>();
    private static Long postId = 0L;

    public Long save(Post post) {
        postId++;
        postRepository.put(postId, post);
        return postId;
    }

    public Post findById(Long id) {
        return postRepository.get(id);
    }

    public List<Post> findAll() {
        return new ArrayList<>(postRepository.values());
    }

    public void delete(Long id, Post post) {
        postRepository.remove(postId, post);
    }
}