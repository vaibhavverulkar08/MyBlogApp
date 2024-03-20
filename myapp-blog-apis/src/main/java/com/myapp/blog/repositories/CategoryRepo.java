package com.myapp.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
