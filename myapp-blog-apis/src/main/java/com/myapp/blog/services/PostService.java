package com.myapp.blog.services;

import java.util.List;

import com.myapp.blog.entities.Post;
import com.myapp.blog.payloads.PostDto;

public interface PostService {

	//create
	PostDto createPost(PostDto postdto,Integer userId,Integer categoryId);
	
	//update
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all post
	List<Post> getAllPost();
	
	//get single post
	Post getPostById(Integer postId);
	
	//get all post by category
	List<Post> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	List<Post> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPost(String keyword);

}
