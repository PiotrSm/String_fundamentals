package com.myspring.fundamentals.controllers;

import com.myspring.fundamentals.controllers.Dto.PostDto;
import com.myspring.fundamentals.model.Post;
import com.myspring.fundamentals.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.myspring.fundamentals.controllers.Dto.PostDtoMapper.mapToPostDtos;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) Integer page,Optional<Sort.Direction> sort) {
        int pageNumber = page !=null && page >= 0 ? page : 0;
        return mapToPostDtos(postService.getPosts(pageNumber, sort.orElse(Sort.Direction.ASC)));//aby uniknąć problemu N+1 i wielu podzapytań musimy przemapowac Post do PostDto
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam Optional<Integer> page, Optional<Sort.Direction> sort) {
        return postService.getPostsWithComments(page.orElse(0), sort.orElse(Sort.Direction.ASC));
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id) {
        return postService.getSinglePost(id);

    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post) {
        return postService.editPost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePost(id);
    }
}
