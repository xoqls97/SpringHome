package com.ezen.www.service;

import java.util.List;

import com.ezen.www.domain.BoardVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> list();

	BoardVO detail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

}
