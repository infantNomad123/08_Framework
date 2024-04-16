package com.kh.test.user.model.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.mapper.UserMapper;


import lombok.RequiredArgsConstructor;
@Service
@Transactional

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserMapper mapper;

	@Override
	public List<User> selectId(String searchId) {
		return mapper.selectId(searchId);
	}
	@Override
	public List<User> selectAll() {
	
		return mapper.selectAll();
	}

	
	
	


	
}
