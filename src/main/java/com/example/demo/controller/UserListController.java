package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.User;
import com.example.demo.model.UserListForm;
import com.example.demo.service.UserSearchService;

@Controller
@RequestMapping("/userList")
public class UserListController {
	
	private Map<String, String> radio;
	
	@Autowired
	private UserSearchService userSearchService;

	@GetMapping("/init")
	public String init(Model model, UserListForm form) {
		radio = createRadio();
		model.addAttribute("sex", radio);
		
		//ユーザー全件検索
		List<User> userList = userSearchService.searchAll();
		model.addAttribute("userList", userList);
		
		model.addAttribute("bottonName", "検索");
		
		return "userList/userList";
	}
	
	@PostMapping("/userSearch")
	public String search(Model model, UserListForm form) {
		
		return "userList/userList";
	}
	
	private Map<String, String> createRadio() {
		
		//ラジオボタン用のマップを準備
		Map<String, String> radio = new LinkedHashMap<>();
		
		radio.put("0", "男性");
		radio.put("1", "女性");
		
		return radio;
	}
}
