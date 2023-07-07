package com.banao.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.banao.model.UserDetails;
import com.banao.service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signIn")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute UserDetails userDetails,HttpSession session) {

		
		//checking if the email id already registered .
		boolean f = userService.checkEmail(userDetails.getEmail());

		if (f) {
		session.setAttribute("sucMsg", "Email id already existed ..");

		} else {
			
			//registering new user details
			UserDetails userDetails2 = userService.registerUserDetails(userDetails);
			if (userDetails2 != null) {
				session.setAttribute("sucMsg", " User Registered Successfully..");

			} else {
				session.setAttribute("sucMsg", "Oooops! Something went wrong on the server..");
			}

		}

		return "redirect:/register";
	}

}
