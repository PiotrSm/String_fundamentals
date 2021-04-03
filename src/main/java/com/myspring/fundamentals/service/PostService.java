package com.myspring.fundamentals.service;

import com.myspring.fundamentals.model.Post;
import com.myspring.fundamentals.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;

    public List<Post> getPosts(int page) {
        //PageRequest.of(0,3) - dodane stronicowanie do zwracanych wyników - zwraca tylko pierwsze 3
        List<Post> postList = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
        return postList;
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
