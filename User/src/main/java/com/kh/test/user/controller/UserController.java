package com.kh.test.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	

	
	@PostMapping("main")
	public String selectId(
			@RequestParam("searchId") String searchId,
			Model model
			){
			List <User> lists = service.selectId(searchId);
			
			if(lists.isEmpty()) {
				return "searchfail";
			}else {
				model.addAttribute("user", lists);
				return "searchSuccess";
			}
			
	}
	
	@ResponseBody
	@GetMapping("main")
	public List <User> selectAll(Model model) {
		List<User> lists = service.selectAll();
		return lists;
	}
	
}
