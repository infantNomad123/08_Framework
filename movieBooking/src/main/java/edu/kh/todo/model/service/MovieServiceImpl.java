package edu.kh.todo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.todo.model.dto.Movie;
import edu.kh.todo.model.mapper.MovieMapper;


@Transactional(rollbackFor = Exception.class)
@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired //DI
	private MovieMapper mapper;
	
	@Override
	public Map<String, Object> selectAll() {
		// TODO Auto-generated method stub
		
		//1. 할일  목록 조회
		List<Movie>movieList = mapper.selectAll();
		

		
		//Map으로 묶어서 반환
		Map<String, Object> map = new HashMap<>();
		
		map.put("movieList",movieList);
	
		
		return map;
	}
}
