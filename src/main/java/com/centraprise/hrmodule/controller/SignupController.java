package com.centraprise.hrmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centraprise.hrmodule.model.User;
import com.centraprise.hrmodule.model.UserRegistration;
import com.centraprise.hrmodule.service.UserSignupService;

@Controller
public class SignupController {

	@Autowired
	private UserSignupService userSignupService;

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("userForm", new UserRegistration());
		return "signup";
	}

	@PostMapping("/signup")
	public @ResponseBody String registerUserAccount(@ModelAttribute("userForm") UserRegistration userDto,
			BindingResult result) {
		System.out.println("here ok");
		User existing = userSignupService.findByusername(userDto.getUsername());
		if (existing != null) {
			result.rejectValue("username", null, "There is already an account registered with that username");
		}

		if (result.hasErrors()) {
			return "signup";
		}

		System.out.println("calling database");
		User userDeta = userSignupService.save(userDto);
		return "record added";
	}

	@GetMapping("/userinfo/{username}")
	public ResponseEntity<Object> signup(@PathVariable("username") String username) {
		System.out.println("getting userinfo");
		System.out.println(userSignupService.findByusername(username));
		return ResponseEntity.ok().body(userSignupService.findByusername(username));
	}
}
