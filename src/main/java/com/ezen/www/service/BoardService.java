package com.ezen.www.service;

import java.util.List;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> list(PagingVO pgvo);

	BoardVO detail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

	int totalCount(PagingVO pgvo);

}
