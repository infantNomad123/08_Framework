package com.kh.test.customer.model.dto;



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
public class Customer {
	private String customerName;
	private String customerTel;
	private String customerAddress;
}
