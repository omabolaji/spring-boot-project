package com.famousbeejay.spring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.famousbeejay.spring.post.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
