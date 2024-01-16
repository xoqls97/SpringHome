package com.ezen.www.domain;

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
public class BoardVO {
//	CREATE TABLE board(
//			bno BIGINT NOT NULL AUTO_INCREMENT,
//			title VARCHAR(200) NOT NULL,
//			writer VARCHAR(100) NOT NULL, 
//			content TEXT NOT NULL,
//			reg_at DATETIME DEFAULT NOW(),
//			mod_at DATETIME DEFAULT NOW(),
//			read_count INT DEFAULT 0,
//			cmt_qty INT DEFAULT 0,
//			has_file INT DEFAULT 0,
//			PRIMARY KEY (bno));
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String reg_at;
	private String mod_at;
	private int read_count;
	private int cmt_qty;
	private int has_file;
	

}
