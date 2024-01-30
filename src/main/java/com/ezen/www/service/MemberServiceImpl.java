package com.ezen.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.www.repository.MemberDAO;
import com.ezen.www.security.AuthVO;
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


	@Override
	public MemberVO modify(String email) {
		List<AuthVO> authList = mdao.selectAuths(email);
		MemberVO mvo = mdao.selectEmail(email);
		mvo.setAuthList(authList);
		return mvo;
		
	}


	@Override
	public void noupdate(MemberVO mvo) {
		mdao.noupdate(mvo);
		
	}


	@Override
	public void update(MemberVO mvo) {
		mdao.update(mvo);
		
	}


	@Override
	public int delete(String email) {
		int isOk=mdao.delete(email);
		return isOk;
		
	}


	@Override
	public List<MemberVO> list() {
		List<MemberVO> list = mdao.list();
		for(int i=0; i<list.size(); i++) {
			list.get(i).setAuthList(mdao.selectAuths(list.get(i).getEmail()));
		}
		return list;
	}


	@Override
	public int getEmail(String email) {
		return mdao.checkEmail(email);
	}
	

}
