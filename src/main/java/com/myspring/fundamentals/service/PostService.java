package com.myspring.fundamentals.service;

import com.myspring.fundamentals.model.Post;
import com.myspring.fundamentals.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        List<Post> postList = postRepository.findAll();
        return postList;
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
