package com.kh.test.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.customer.model.service.CustomerService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService service;
	
	@PostMapping("main")
	public String addCustomer(
			@RequestParam("inputName") String customerName,
			@RequestParam("inputTel") String customerTel,
			@RequestParam("inputAddress") String customerAddress,Model model
			
			) {
		
		   int result = service.addCustomer(customerName, customerTel, customerAddress);
		   String message = null;
		   if(result > 0) {
			    message = "수정 성공!!";
			   model.addAttribute("remark", message);
			   
			   return "result";
		   }
		   
		  message = "회원 번호가 일치하는 회원이 없습니다";
		   model.addAttribute("remark", message);
		   return "redirect:/";
		   
	}
	
	

	
	
	
}
