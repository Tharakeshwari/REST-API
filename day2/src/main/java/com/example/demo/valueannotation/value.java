package com.example.demo.valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class value {
	@Value("${greeting.message}")
	private String str;
	@RequestMapping("/val")
	public String display() {
		return str;
	}

}
