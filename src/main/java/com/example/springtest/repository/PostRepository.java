package com.example.springtest.repository;

import com.example.springtest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByOrderByModifiedAtDesc();

}
