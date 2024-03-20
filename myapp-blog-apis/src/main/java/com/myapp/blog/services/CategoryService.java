package com.myapp.blog.services;

import java.util.List;

import com.myapp.blog.payloads.CategoryDto;

public interface CategoryService {
	//adding all methods related category:
	
	//create
	CategoryDto createCategory(CategoryDto categoryDTO);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDTO, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);

	//get
	CategoryDto getCategory(Integer categoryId);
	
	//get All
	List<CategoryDto> getCategories();
	
	//you can add or create your custom method.
}
