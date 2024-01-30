package com.ezen.www.service;

import java.util.List;

import com.ezen.www.security.MemberVO;

public interface MemberService {

	boolean updateLastLogin(String authEmail);

	int register(MemberVO mvo);

	MemberVO modify(String email);

	void noupdate(MemberVO mvo);

	void update(MemberVO mvo);

	int delete(String email);

	List<MemberVO> list();

	int getEmail(String email);

}
