package com.myspring.fundamentals.controllers;

import com.myspring.fundamentals.controllers.Dto.PostDto;
import com.myspring.fundamentals.model.Post;
import com.myspring.fundamentals.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.myspring.fundamentals.controllers.Dto.PostDtoMapper.mapToPostDtos;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) int page) {
        int pageNumber = page >= 0 ? page : 0;
        return mapToPostDtos(postService.getPosts(pageNumber));//aby uniknąć problemu N+1 i wielu podzapytań musimy przemapowac Post do PostDto
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id) {
        return postService.getSinglePost(id);

    }
}
