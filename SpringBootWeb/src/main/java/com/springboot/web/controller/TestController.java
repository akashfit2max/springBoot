package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/run")
	@ResponseBody
	public String run() {
		return "my first spring boot project";
	}

	@RequestMapping("/")
	public String home() {
		System.out.println("insi"
				+ "de home page");
		return "home";
	}
}
