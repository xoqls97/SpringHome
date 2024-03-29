package com.ezen.www.security;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String email;
	private String pwd;
	private String nickname;
	private String regdate;
	private String lastlogin;
	private List<AuthVO> authList;

}
