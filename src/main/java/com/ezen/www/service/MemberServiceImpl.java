package com.ezen.www.service;

import org.springframework.stereotype.Service;

import com.ezen.www.repository.MemberDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberServiceImpl implements MemberService{
	private final MemberDAO mdao;

	@Override
	public boolean updateLastLogin(String authEmail) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
