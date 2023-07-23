package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.SampleForm;

@Controller
@RequestMapping("/sampleForm")
public class FormSampleController {
	
	@GetMapping("/init")
	public String getInit(Model model, SampleForm form) {
		model.addAttribute("radio", getRadio());
		model.addAttribute("checkBox", getCheckBox());
		model.addAttribute("pulldown", getPulldown());
		return "sampleForm/sampleForm";
	}
	
	@PostMapping("/post")
	public String postInit(Model model, SampleForm form) {
		
		return getInit(model, form);
	}
	
	private static Map<String, String> getRadio() {
		Map<String, String> radio = new LinkedHashMap<>();
		
		radio.put("0", "ラジオボタン0");
		radio.put("1", "ラジオボタン1");
		radio.put("2", "ラジオボタン２");
		
		return radio;
	}
	
	private static Map<String, String> getCheckBox() {
		Map<String, String> checkBox = new LinkedHashMap<>();
		
		checkBox.put("0", "チェックボックス0");
		checkBox.put("1", "チェックボックス1");
		checkBox.put("2", "チェックボックス2");
		
		return checkBox;
	}
	
	private static Map<String, String> getPulldown() {
		Map<String, String> pulldown = new LinkedHashMap<>();
		
		pulldown.put("0", "プルダウン0");
		pulldown.put("1", "プルダウン1");
		pulldown.put("2", "プルダウン2");
		
		return pulldown;
	}

}
