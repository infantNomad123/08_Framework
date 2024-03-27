package edu.kh.todo.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.todo.model.dto.Movie;

@Mapper
public interface MovieMapper {

	List<Movie> selectAll();

}
