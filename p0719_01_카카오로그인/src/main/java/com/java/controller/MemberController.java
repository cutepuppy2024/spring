package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/doLogin")
	public ModelAndView doLogin(MemberDto memberDto) {
		System.out.println("memberDto id : "+ memberDto.getId()); // id와 pw가 넘어왔는지 먼저 확인
		System.out.println("memberDto pw : "+ memberDto.getPw());
		
		int chkLogin =0; // 로그인 실패
		
		MemberDto mDto = memberService.selectLogin(memberDto); // 생성자의 객체사용, service의 함수-> 참조변수 mDto로
		if(mDto !=null) { // 로그인 성공
			chkLogin = 1;
			System.out.println("controller name : "+ mDto.getName()); // 참조변수로 변환된 객체 사용 
			session.setAttribute("sessionId", mDto.getId());
			session.setAttribute("sessionId", mDto.getName());
		}
		
		System.out.println("controller chkLogin :" + chkLogin); // 0 or 1 중 성공, 실패로 찍힘 <- xml에서 id와 pw 비교하여 성공여부에 따라

		ModelAndView mv = new ModelAndView();
		mv.addObject("chkLogin",chkLogin); 
		mv.setViewName("member/doLogin");
		return mv; // mv 값을 view로 보냄
	}
	
	@RequestMapping("/member/logout")
	public ModelAndView logout(MemberDto memberDto) {
		
		int chkLogin =3;
		
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.addObject("chkLogin",chkLogin); 
		mv.setViewName("member/doLogin");
		return mv;

	}
	

}
