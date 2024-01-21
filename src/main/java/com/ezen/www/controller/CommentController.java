package com.ezen.www.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.www.domain.CommentVO;
import com.ezen.www.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/comment/**")
@RequiredArgsConstructor
public class CommentController {
	private final CommentService csv;
	
	@PostMapping(value="/post", consumes = "application/json",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> post(@RequestBody CommentVO cvo){
		log.info(">>>cvo>>{}",cvo);
		int isOk=csv.post(cvo);
		return isOk>0 ?
				new ResponseEntity<String>("1",HttpStatus.OK) :
					new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/list{bno}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CommentVO> list(@PathVariable("bno") int bno) {
		log.info(">>>bno>>>>"+bno);
		List<CommentVO> list=csv.list(bno);
		
		return list;
	}
	
	@PutMapping(value="/edit",consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> edit(@RequestBody CommentVO cvo){
		log.info(">>> cvo>"+cvo);
		int isOk = csv.modify(cvo);
		return isOk>0 ? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> delete(@RequestBody int cno){
		log.info(">>>cno>>>"+cno);
		int isOk=csv.delete(cno);
		return isOk>0 ? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	


}
