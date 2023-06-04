package com.example.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UserDao;
import com.example.demo.data.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class testController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping("/test")
	public String getTest() {

		userDao.testSelect();

		return "test";
	}
	
	@PostMapping("/test")
	public String postTest(@RequestParam("employeeId")String employeeId, Model model) {
		
		int idInt = Integer.parseInt(employeeId);
		Employee employee = employeeService.findOne(idInt);
		
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getEmployeeId());
		
		return "testDb";
	}
}
