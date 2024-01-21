package com.ezen.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.www.domain.BoardDTO;
import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.FileVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.repository.BoardDAO;
import com.ezen.www.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardDAO bdao;
    private final FileDAO fdao;
	
    @Override
	public int register(BoardDTO bdto) {
    	int isOk=bdao.register(bdto.getBvo());
    	if(bdto.getFlist() == null) {
    		return isOk;
    	}
    	
    	if(isOk>0 && bdto.getFlist().size()>0) {
    		long bno = bdao.selectOneBno();
    		for(FileVO fvo : bdto.getFlist()) {
    			fvo.setBno(bno);
    			isOk*=fdao.insertFile(fvo);
    			
    		} 
    	}
    	return isOk;
	}

	@Override
	public List<BoardVO> list(PagingVO pgvo) {
		return bdao.list(pgvo);
	}

	@Override
	public BoardDTO detail(int bno) {
		BoardVO bvo =bdao.detail(bno);
		List<FileVO>flist = fdao.getFileList(bno);
		BoardDTO bdto = new BoardDTO(bvo,flist);
		return bdto;
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
