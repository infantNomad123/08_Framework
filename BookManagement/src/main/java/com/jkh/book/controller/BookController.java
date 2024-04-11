package com.jkh.book.controller;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jkh.book.model.dto.Book;
import com.jkh.book.model.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
public class BookController {
	
	private final BookService service;
	
	@RequestMapping("/")
	public String getMain() {
		return "bookManagement/main";
	}
	@GetMapping("register")
	public String getRegisterPage() {
		return "bookManagement/register";
	}
	@	PostMapping("register")
	public String getRegister(
			@RequestParam("bookTitle") String bookTitle,
			@RequestParam("bookWriter") String bookWriter,
			@RequestParam("bookPrice") int bookPrice,
			RedirectAttributes ra
			) {
		
		int result = service.getRegister(bookTitle, bookWriter, bookPrice);
		

		String message  =null;
		
		if(result > 0) {
			message = "등록!!";
			return "bookManagement/register";
		}
		ra.addFlashAttribute(message);
		return "redirect:/";
		
	}
	
	@ResponseBody
	@GetMapping("main")
	public List<Book> selectAll(){
		List<Book> bookLists = service.selectAll();
		return bookLists;
		
	}
	
	


}
