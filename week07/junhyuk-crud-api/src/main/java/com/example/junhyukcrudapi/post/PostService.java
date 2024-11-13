package com.example.junhyukcrudapi.post;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Long createPost(CreatePostRequest createPostRequest) {
        Post post = createPostRequest.toEntity();
        return postRepository.save(post);
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> PostResponse.from(postRepository.findAll().indexOf(post) + 1L, post))
                .collect(Collectors.toList());
    }
}
