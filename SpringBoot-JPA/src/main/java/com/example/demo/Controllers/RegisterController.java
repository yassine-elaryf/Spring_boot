package com.example.demo.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.UsersEntity;



@Controller
public class RegisterController {
	@Autowired
	private UserDAO userDAO;
	@GetMapping(value = "/register")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response) {
		 ModelAndView mav = new ModelAndView("register");		 
		 mav.addObject("user", new UsersEntity());
		 return mav;
}
	@PostMapping(value = "/registerForm")
	public ModelAndView addUser(HttpServletRequest request,
			HttpServletResponse response ,@ModelAttribute("user") UsersEntity user) {
		userDAO.register(user);
	    return new ModelAndView("index","fullname",user.getUserName());
				}
}
