package com.example.demo.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
	
	@GetMapping("/test")
	public String getTest() {
		return "test";
	}
}
