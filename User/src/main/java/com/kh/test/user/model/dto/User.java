package com.kh.test.user.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter // Spring EL, Mybatis  
@Setter // 커맨드 객체
@NoArgsConstructor // 기본 생성자 (커맨드 객체)
@ToString
@Builder
@AllArgsConstructor
public class User {
	private int userNo;
	private String userId;
	private String userName;
	private int userAge;
	
}
