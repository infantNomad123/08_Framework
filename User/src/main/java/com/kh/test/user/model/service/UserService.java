package com.kh.test.user.model.service;

import java.util.List;
import java.util.Map;

import com.kh.test.user.model.dto.User;

public interface UserService {




	List<User> selectId(String searchId);

	List<User> selectAll();

}
