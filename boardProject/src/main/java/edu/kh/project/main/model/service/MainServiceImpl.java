package edu.kh.project.main.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.main.model.mapper.MainMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
	private final MainMapper mapper;
	private final BCryptPasswordEncoder bcrypt; 
	
	
	@Override
	public int resetPw(int inputNo) {
	
		String pw = "piss01!";
		String encPw = bcrypt.encode(pw);
		
		Map<String,Object> map = new HashMap<>();
		map.put("inputNo" , inputNo);
		map.put("encPw" , encPw);
		return  mapper.resetPw(map);
	}
	
	@Override
	public int recover(int inputNo) {
		return mapper.recover(inputNo);
	}
	
	@Override
	public int delMem(int inputNo) {
		return mapper.delMem(inputNo);
	}

}
