package com.myapp.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.blog.entities.Category;
import com.myapp.blog.entities.Post;
import com.myapp.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
 List<Post>	findByUser(User user);
 
 List<Post> findByCategory(Category category);
 
}
