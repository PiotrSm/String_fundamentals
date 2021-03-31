package com.myspring.fundamentals.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    private long id;
    private String content;
    private String created;
}
