package com.jkh.book.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jkh.book.model.dto.Book;
import com.jkh.book.model.mapper.BookMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
	
	private final BookMapper mapper;
	
	@Override
	public int getRegister(String bookTitle, String bookWriter, int bookPrice) {
		Book book = new Book();
		book.setBookTitle(bookTitle);
		book.setBookWriter(bookWriter);
		book.setBookPrice(bookPrice);
		return mapper.getRegister(book);
	}

	@Override
	public List<Book> selectAll() {
		return mapper.selectAll();
	}

}
