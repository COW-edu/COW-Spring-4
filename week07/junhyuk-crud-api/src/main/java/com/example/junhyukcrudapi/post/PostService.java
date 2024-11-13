package com.example.junhyukcrudapi.post;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            postResponses.add(PostResponse.from((long) (i + 1), post));
        }
        return postResponses;
    }

    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id);
        return PostResponse.from(id, post);
    }
}
