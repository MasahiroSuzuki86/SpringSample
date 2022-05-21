package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	//Getメソッドを処理
	@GetMapping("/hello")
	public String getHello() {
		//hello.htmlに画面遷移
		return "hello";
	}
	
	//Postメソッドを処理
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String text1, Model model) {
		
		//画面から受け取った文字列をModelに登録
		model.addAttribute("sample", text1);
		
		//helloResponse.htmlに画面遷移
		return "helloResponse";
		
	}
	
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String text2, Model model) {
		
		int id = Integer.parseInt(text2);
		
		//１件検索
		Employee employee = helloService.findOne(id);
		
		//結果をmodelに格納
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getAge());
		
		//画面遷移
		return "helloResponseDB";
	}
}