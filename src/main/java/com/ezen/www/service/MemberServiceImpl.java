package com.ezen.www.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.www.repository.MemberDAO;
import com.ezen.www.security.MemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberServiceImpl implements MemberService{
	private final MemberDAO mdao;


	@Transactional
	@Override
	public int register(MemberVO mvo) {
		int isOk=mdao.register(mvo);
		return mdao.insertAuthInit(mvo.getEmail());
	}
	
	
	@Override
	public boolean updateLastLogin(String authEmail) {
		return mdao.updateLastLogin(authEmail)>0 ? true:false;
	}
	

}
