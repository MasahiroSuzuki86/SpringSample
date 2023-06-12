package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.SignupForm;

@Controller
public class SignupController {
	
	//ラジオボタン
	private Map<String, String> radioSex;
	
	//ラジオボタンの初期化メソッド
	private Map<String, String> initRadioSex() {
		
		Map<String, String> radio = new LinkedHashMap<>();
		
		//男性、女性、その他をMapに格納
		radio.put("男性", "0");
		radio.put("女性", "1");
		
		return radio;
	}
	
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {
		
		//ラジオボタン初期化
		radioSex = initRadioSex();
		
		model.addAttribute("sex", radioSex);
		
		return "login/signup";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form, 
				BindingResult bindingResult, 
				Model model) {
		
		if(bindingResult.hasErrors()) {
			return getSignUp(form, model);
		}
		
		System.out.println(form);
		
		return "redirect:login";
	}
}
