package com.ezen.www.service;

import org.springframework.stereotype.Service;

import com.ezen.www.domain.CommentVO;
import com.ezen.www.repository.CommentDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		return cdao.post(cvo);
	}

}
