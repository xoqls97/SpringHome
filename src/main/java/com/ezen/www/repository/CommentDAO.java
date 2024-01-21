package com.ezen.www.repository;

import java.util.List;

import com.ezen.www.domain.CommentVO;

public interface CommentDAO {

	int post(CommentVO cvo);

	List<CommentVO> list(int bno);

	int modify(CommentVO cvo);

	int delete(int cno);

}
