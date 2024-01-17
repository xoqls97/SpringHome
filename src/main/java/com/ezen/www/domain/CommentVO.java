package com.ezen.www.domain;

import org.apache.ibatis.type.Alias;

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
public class CommentVO {
	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;
	

}
