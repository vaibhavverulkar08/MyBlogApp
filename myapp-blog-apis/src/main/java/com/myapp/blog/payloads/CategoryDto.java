package com.myapp.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;

	@NotBlank
	@Size(min = 4 ,message = "Minimum size of category Title is 4")
	private String categoryTitle;

	@NotBlank
	@Size(min =10, message = "Minimum size of category Description is 10")
	private String categoryDescription;
}

//added validation on date 20.03.24. i.e. @NotBlank @Size(max=10,min=4,message="abc..")