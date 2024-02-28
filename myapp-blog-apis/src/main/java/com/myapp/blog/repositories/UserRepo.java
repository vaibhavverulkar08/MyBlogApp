package com.myapp.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
