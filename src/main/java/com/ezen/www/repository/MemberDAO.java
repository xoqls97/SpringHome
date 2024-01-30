package com.ezen.www.repository;

import java.util.List;

import com.ezen.www.security.AuthVO;
import com.ezen.www.security.MemberVO;

public interface MemberDAO {

	MemberVO selectEmail(String username);

	List<AuthVO> selectAuths(String username);

	int register(MemberVO mvo);

	int insertAuthInit(String email);

	int updateLastLogin(String authEmail);

	void noupdate(MemberVO mvo);

	void update(MemberVO mvo);

	int delete(String email);

	List<MemberVO> list();

	int checkEmail(String email);

}
