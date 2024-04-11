package com.jkh.book.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jkh.book.model.dto.Book;

@Mapper
public interface BookMapper {

	int getRegister(Book book);

	List<Book> selectAll();

}
