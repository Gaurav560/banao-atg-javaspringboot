package com.banao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.banao.model.UserDetails;
import com.banao.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute UserDetails userDetails) {

		boolean f = userService.checkEmail(userDetails.getEmail());

		if (f) {
			System.out.println("email id already exists.");

		} else {
			UserDetails userDetails2 = userService.registerUserDetails(userDetails);
			if (userDetails2 != null) {
				System.out.println("Details Registered Successfully..");

			} else {
				System.out.println("Oops! Something went wrong on the server..");
			}

		}

		return "redirect:/register";
	}

}
