package com.myapp.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "user_name", nullable = false, length = 100)
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;
	
	//mapping for post
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
}
