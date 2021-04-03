package com.myspring.fundamentals.service;

import com.myspring.fundamentals.model.Comment;
import com.myspring.fundamentals.model.Post;
import com.myspring.fundamentals.repository.CommentRepository;
import com.myspring.fundamentals.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPosts(int page, Sort.Direction sort) {
        //PageRequest.of(0,3) - dodane stronicowanie do zwracanych wyników - zwraca tylko pierwsze 3
        ;
        List<Post> postList = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
        return postList;
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> postList = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,Sort.by(sort, "id")));
        List<Long> ids = postList.stream().map(Post::getId).collect(Collectors.toList());
        List<Comment> comments = commentRepository.findByPostIdIn(ids);
        postList.forEach(post -> post.setComments(extractComments(comments, post.getId())));
        return postList;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }
}
