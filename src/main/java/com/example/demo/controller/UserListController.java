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
	
	/** ラジオボタン表示用の情報を保持する変数 */
	private Map<String, String> radio;
	
	@Autowired
	private UserSearchService userSearchService;

	/**
	 * Get通信を処理するメソッド
	 * http://localhost:8080/userList/init を処理する
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("/init")
	public String init(Model model, UserListForm form) {
		
		//ラジオボタン初期化
		radio = createRadio();
		model.addAttribute("sexRadio", radio);
		model.addAttribute("sex", "0");
		
		//ユーザー全件検索
		List<User> userList = userSearchService.searchAll();
		model.addAttribute("userList", userList);
		
		return "userList/userList";
	}
	
	/**
	 * Post通信を処理するメソッド
	 *　http://localhost:8080/userList/userSearch を処理する
	 * @param model
	 * @param form
	 * @return
	 */
	@PostMapping("/userSearch")
	public String search(Model model, UserListForm form) {
		System.out.println(form);
		return "userList/userList";
	}
	
	/**
	 * ラジオボタン表示用の情報を詰めるメソッド
	 * @return
	 */
	private Map<String, String> createRadio() {
		
		//ラジオボタン用のマップを準備
		Map<String, String> radio = new LinkedHashMap<>();
		
		radio.put("0", "全て");
		radio.put("1", "男性");
		radio.put("2", "女性");
		
		return radio;
	}
}
