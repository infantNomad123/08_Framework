package edu.kh.todo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private  String movieName;
	private  int price;
	private  int rating;
	private int movieNo;
}
