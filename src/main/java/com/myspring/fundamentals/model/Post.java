package com.myspring.fundamentals.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;
}
