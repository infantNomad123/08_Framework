package com.kh.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.model.dto.User;
import com.kh.test.model.service.UserService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	@GetMapping("main")
	public String searchUser(
			@RequestParam("inputNo") int inputNo,
			Model model) {
		User user = service.searchUser(inputNo);
		
		if(user != null) {
			model.addAttribute("user", user);
			return "searchSuccess";
		}
		else {
			return "searchFail";
		}
		
	}

}
