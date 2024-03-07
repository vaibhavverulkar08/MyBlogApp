package com.myapp.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyappBlogApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappBlogApisApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() 
	{	
		return new ModelMapper();
	}
	
}
