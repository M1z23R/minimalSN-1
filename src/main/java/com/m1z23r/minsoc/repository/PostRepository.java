package com.m1z23r.minsoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m1z23r.minsoc.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	
}
