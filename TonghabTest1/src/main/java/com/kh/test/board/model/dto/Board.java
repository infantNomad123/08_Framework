package com.kh.test.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int userNo;
	private String boardTitle;
	private String userId;
	private String boardContent;
	private int boardReadcount;
	private String boardDate;
}
