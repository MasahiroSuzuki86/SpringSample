package com.example.demo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	private String userId;
	private String password;
	private String name;
	private String address;
	private int age;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	private String sex;

}
