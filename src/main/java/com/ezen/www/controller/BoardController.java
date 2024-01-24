package com.ezen.www.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.www.domain.BoardDTO;
import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.FileVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.handler.FileHandler;
import com.ezen.www.handler.PagingHandler;
import com.ezen.www.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/**")
@Controller
@RequiredArgsConstructor //생성자
public class BoardController {

	private final BoardService bsv;
	private final FileHandler fh;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(Model m,BoardVO bvo, @RequestParam(name="file",required=false) MultipartFile[] file) {
		log.info(">>>bvo>>{}",bvo);
		List<FileVO> flist = null;
		if(file[0].getSize()>0) {
			flist = fh.uploadFiles(file);
		}
		int isOk=bsv.register(new BoardDTO(bvo,flist));
		
		m.addAttribute("registermsg",isOk);
		
		return "index";
		
	}
	
	@GetMapping("/list")
	public String list(Model m,PagingVO pgvo) {
		log.info(">>>> pgvo >> {} ",pgvo);
		List<BoardVO> list = bsv.list(pgvo);
		m.addAttribute("list",list);
		int totalCount = bsv.totalCount(pgvo);
		PagingHandler ph = new PagingHandler(pgvo,totalCount);
		m.addAttribute("ph",ph);
		return "/board/list";
	}
	
	@GetMapping("/detail")
	public void detail(@RequestParam("bno") int bno, Model m) {
		m.addAttribute("bdto",bsv.detail(bno));
		
	}

	@GetMapping("/modify")
	public void modify(@RequestParam("bno")int bno,Model m) {
	log.info(">>>>>>>>bno>>>>>>>> {}",bno);
	m.addAttribute("bdto",bsv.detail(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo,RedirectAttributes re,
			@RequestParam(name="file",required=false)MultipartFile[] file) {
		List<FileVO> flist = null;
		if(file[0].getSize()>0) {
			flist = fh.uploadFiles(file);
		}
		log.info(">>bvo>>>>>>>>>"+bvo);
		int isOk=bsv.modify(new BoardDTO(bvo,flist));
		re.addAttribute("bno",bvo.getBno());
		re.addFlashAttribute("modifymsg",isOk);
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int bno,RedirectAttributes re) {
		int isOk=bsv.delete(bno);
		re.addFlashAttribute("deletemsg",isOk);
		return "redirect:/board/list";
	}
	
	@DeleteMapping(value="/deletefile",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deletefile(@RequestBody FileVO fvo){
		log.info(">> uuid>>{}",fvo.getUuid());
		int isOk = bsv.deletefile(fvo.getUuid());
		return isOk>0 ? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
