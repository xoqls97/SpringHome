package com.ezen.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.repository.BoardDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardDAO bdao;

	@Override
	public int register(BoardVO bvo) {
		return bdao.register(bvo);
	}

	@Override
	public List<BoardVO> list(PagingVO pgvo) {
		return bdao.list(pgvo);
	}

	@Override
	public BoardVO detail(int bno) {
		return bdao.detail(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		return bdao.modify(bvo);
	}

	@Override
	public int delete(int bno) {
		return bdao.delete(bno);
	}


	@Override
	public int totalCount(PagingVO pgvo) {
		return bdao.totalCount(pgvo);
	}

}
