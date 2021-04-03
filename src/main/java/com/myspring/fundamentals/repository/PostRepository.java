package com.myspring.fundamentals.repository;

import com.myspring.fundamentals.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p")
    List<Post> findAllPosts(Pageable page);//Pageable page - dodane stronicowanie

//    @Query("select p from Post left join fetch p.comments")
    //tak działa ale wgrywa wszystkie rekordy i dopiero przycina - nieefektywne

//    @Query("select p from Post p")
    //tak też działa ale pozostaje problem N+1 - za dużo selectów do comments

}
