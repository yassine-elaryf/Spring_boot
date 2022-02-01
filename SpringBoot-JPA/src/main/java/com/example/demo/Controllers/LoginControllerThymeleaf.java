package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControllerThymeleaf {
	@RequestMapping(value = "/hello")
	public  String homePage() { 
		return "index1";
	}
}
