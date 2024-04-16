package com.kh.test.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.model.dto.User;
import com.kh.test.model.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
@Transactional
@Service

@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserMapper mapper;
	
	@Override
	public User searchUser(int inputNo) {
		return mapper.searchUser(inputNo);
	}

}
