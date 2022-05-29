package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.login.domain.model.SignupForm;


@Controller
public class SignupController {
	
	//ラジオボタンの実装
	private Map<String, String> radioMarriage;
	
	//ラジオボタンの初期化メソッド
	private Map<String, String> initRadioMarrige() {
		Map<String, String> radio = new LinkedHashMap<>();
		
		//既婚、未婚をMapに格納
		radio.put("既婚", "true");
		radio.put("未婚", "false");
		
		return radio;
	}
	
	//ユーザー登録画面のGETコントローラー
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {
		//ラジオボタンの初期化
		radioMarriage = initRadioMarrige();
		
		//ラジオボタン用のMapを登録
		model.addAttribute("radioMarriage", radioMarriage);
		
		//signup.htmlに画面遷移
		return "login/signup";
	}
	
	//ユーザー登録画面のPOSTコントローラー
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, 
			BindingResult bindingResult, 
			Model model) {
		
		if(bindingResult.hasErrors()) {
			//エラーがある場合ユーザー登録画面に戻る
			return getSignUp(form, model);
		}
		
		//テスト用
		System.out.println(form);
		
		//login.htmlにリダイレクト
		return "redirect:/login";
	}

}
