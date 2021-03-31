package com.myspring.fundamentals.controllers;

import com.myspring.fundamentals.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @GetMapping("/posts")
    public List<Post> getPosts(){
        throw new IllegalArgumentException("Not implemented yet!");

    }

    @GetMapping("/posts/{id}")
    public List<Post> getSinglePost(@PathVariable long id){
        throw new IllegalArgumentException("Not implemented yet!");

    }
}
