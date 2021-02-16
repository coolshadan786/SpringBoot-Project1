package com.springbootproject.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody			//It is used for String return type value from the it's class mtdh
public class MainController {
	
	@RequestMapping("/test")
	@ResponseBody			//It is used for String return type value from the it's class mtdh it uses in either over class or over particular mtdh
	public String firsthandler() {
		int a = 10;
		int b = 20;
		int c= 30;
		return "Just for testing !!" + (a+b+c);
	}
	
	@RequestMapping("/")
	
	public String home() {
		System.out.println("This is home page ..........");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("This is contact page.............");
		return "contact";
	}

}
