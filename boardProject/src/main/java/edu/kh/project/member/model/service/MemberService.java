package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/**로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);

	/**회원 가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int signup(Member inputMember, String[] memberAddress);

	/**이메일 중복 검사
	 * @param memberEmail
	 * @return count
	 */
	int checkEmail(String memberEmail);

	int checkNickname(String memberNickname);

	int telNo(String telNo);

	/** 빠른 로그인
	 * @param memberEmail
	 * @return  loginMember
	 */
	Member quickLogin(String memberEmail);

	/**
	 * @return
	 */
	List<Member> selectAll();

}
