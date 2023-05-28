package com.example.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.UserDao;

@Controller
public class testController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/test")
	public String getTest() {
		userDao.testSelect();
		return "test";
	}
}
