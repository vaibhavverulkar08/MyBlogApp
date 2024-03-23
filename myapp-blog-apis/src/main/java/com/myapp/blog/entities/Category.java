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
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
	// Making Category entity & Adding Category Field as per ER-Diagram
	// (Requirements)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;

	@Column(name = "title", length = 100, nullable = false)
	private String categoryTitle;

	@Column(name = "description")
	private String categoryDescription;

	// Getter & setter is used using lombok.
	
	//Adding Mapping for Post Entity to mapped with Category after adding Post Entity.
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
	
}
