package com.ezen.www.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;
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
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO bvo,Model m) {
		int isOk=bsv.register(bvo);
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
		m.addAttribute("bvo",bsv.detail(bno));
		
	}

	@GetMapping("/modify")
	public void modify(@RequestParam("bno")int bno,Model m) {
	log.info(">>>>>>>>bno>>>>>>>> {}",bno);
	m.addAttribute("bvo",bsv.detail(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo,RedirectAttributes re) {
		log.info(">>bvo>>>>>>>>>"+bvo);
		int isOk=bsv.modify(bvo);
		re.addFlashAttribute("modifymsg",isOk);	
		
		return "redirect:/board/detail?bno="+bvo.getBno();
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int bno,RedirectAttributes re) {
		int isOk=bsv.delete(bno);
		re.addFlashAttribute("deletemsg",isOk);
		return "redirect:/board/list";
	}
	
	
	
	
}
