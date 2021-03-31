package com.myspring.fundamentals.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;
}
