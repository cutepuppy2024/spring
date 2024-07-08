package com.java.Controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

@Controller
public class FrontController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
//	@RequestMapping("/doMember")
//	public String doMember(HttpServletRequest request, Model model) {
//		
//		model.addAttribute("id",request.getParameter("id"));
//		model.addAttribute("pw",request.getParameter("pw"));
//		model.addAttribute("name",request.getParameter("name"));
//		model.addAttribute("phone",request.getParameter("phone"));
//		model.addAttribute("gender",request.getParameter("gender"));
//		model.addAttribute("hobby",request.getParameterValues(toString("hobby")));
//		return "doMember";
//
//	}
	
	@RequestMapping("/member")// 회원가입폼
	public String member() {
		return "member";
	}
	
	@RequestMapping("/doMember")
	public ModelAndView doMember(HttpServletRequest request) {
		String[] hobby = request.getParameterValues("hobby");	
		String hobbys = "";
		for(int i=0;i<hobby.length;i++) {
			if(i==0) hobbys += ""+hobby[i];
			else hobbys += ","+hobby[i];
		}
		System.out.println("hobbys :" +hobbys);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",request.getParameter("id"));
		mv.addObject("pw",request.getParameter("pw"));
		mv.addObject("name",request.getParameter("name"));
		mv.addObject("phone",request.getParameter("phone"));
		mv.addObject("gender",request.getParameter("gender"));
		mv.addObject("hobby",hobbys);
		mv.setViewName("doMember"); //파일이름
		return mv;
	
	}
	
	@RequestMapping("/memUpdate") // 회원정보수정
	public ModelAndView memUpdate(HttpServletRequest request) {
		String[] hobby = request.getParameterValues("hobby");
		String hobbys = "";
		for(int i=0;i<hobby.length;i++) {
			if(i==0) hobbys += ""+hobby[i];
			else hobbys += ","+hobby[i];
		}
		System.out.println("hobbys :" +hobbys);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",request.getParameter("id"));
		mv.addObject("pw",request.getParameter("pw"));
		mv.addObject("name",request.getParameter("name"));
		mv.addObject("phone",request.getParameter("phone"));
		mv.addObject("gender",request.getParameter("gender"));
		mv.addObject("hobby",hobbys);
		mv.setViewName("doMember"); //파일이름
		
		
		return mv;
	}
	

	
}
