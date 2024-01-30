package com.ezen.www.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.www.security.MemberVO;
import com.ezen.www.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member/**")
@Controller
public class MemberController {
	
	private final MemberService msv;
	private final BCryptPasswordEncoder bcEncoder;
	
	@GetMapping("/register")
	public void register() {
	}
	
	@PostMapping("/register")
	public String register(MemberVO mvo,Model m) {
		mvo.setPwd(bcEncoder.encode(mvo.getPwd()));
		log.info(">>> register>>mvo>>{}",mvo);
		int isOk = msv.register(mvo);
		m.addAttribute("memberinsertmsg",isOk);
		return "index";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, RedirectAttributes re) {
		re.addAttribute("email",request.getAttribute("email"));
		re.addAttribute("errMsg",request.getAttribute("errMsg"));
		
		return "redirect:/member/login";
		
	}
	
	@GetMapping("/modify")
	public void modify(Principal p , Model m) {
		log.info(">>>principal >> email" + p.getName());
		String email = p.getName();
		m.addAttribute("mvo",msv.modify(email));
	}
	
	@PostMapping("/modify")
	public String modify(MemberVO mvo, HttpServletRequest request, HttpServletResponse response) {
		if(mvo.getPwd().isEmpty()) {
			msv.noupdate(mvo);
		}else {
			mvo.setPwd(bcEncoder.encode(mvo.getPwd()));
			msv.update(mvo);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		new SecurityContextLogoutHandler().logout(request, response, authentication);
		
		return "/member/login";
		
	}
	
	@GetMapping("/delete")
	public String delete(Model m,@RequestParam("email") String email, HttpServletRequest request,HttpServletResponse response) {
		int isOk=msv.delete(email);
		m.addAttribute("deletemsg",isOk);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		new SecurityContextLogoutHandler().logout(request, response, authentication);
		return "/member/login";
	}
	
	@GetMapping("/list")
	public String list(Model m) {
		List<MemberVO> list= msv.list();
		m.addAttribute("list",list);
		return "/member/list";
	}
	

	@ResponseBody
	@GetMapping("/{email}")
	public String validationEmail(@PathVariable("email") String email){
		
		log.info(">>> email {}",email);
		int isOk = msv.getEmail(email);
		return isOk > 0 ? "1" : "0";

	
	}
	
	
	
	
	

}
