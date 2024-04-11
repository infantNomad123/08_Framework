package com.jkh.book.model.service;

import java.util.List;

import com.jkh.book.model.dto.Book;

public interface BookService {

	int getRegister(String bookTitle, String bookWriter, int bookPrice);

	List<Book> selectAll();

}
