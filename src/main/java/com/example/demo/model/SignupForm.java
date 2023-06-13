package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank
	@Size(max=30)
	private String userId;
	
	@NotBlank
	@Size(max=30)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;
	
	@NotBlank
	@Size(max=50)
	private String name;
	
	@NotBlank
	@Size(max=150)
	private String address;
	
	@Min(0)
	@Max(150)
	private int age;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	
	@NotNull
	private String sex;

}
