package com.ezen.www.service;

import java.util.List;

import com.ezen.www.domain.BoardDTO;
import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;

public interface BoardService {

	int register(BoardDTO bdto);

	List<BoardVO> list(PagingVO pgvo);

	BoardDTO detail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

	int totalCount(PagingVO pgvo);

}
