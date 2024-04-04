package edu.kh.project.myPage.model.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원 정보 수정
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int updateInfo(Member inputMember, String[] memberAddress);

	/** 비밀번호 수정
	 * @param paramMap
	 * @param memberNo
	 * @return result
	 */
	int changePw(Map<String, Object> paramMap, int memberNo);


	/**
	 * @param memberNo
	 * @param memberPw
	 * @return
	 */
	int updateYN(int memberNo, String memberPw);

	/**파일 업로드 테스트 1
	 * @param uploadFile
	 * @return
	 */
	String fileUpload1(MultipartFile uploadFile) throws IllegalStateException, IOException;

}