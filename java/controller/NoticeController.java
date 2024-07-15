package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.NoticeDto;
import com.java.service.NoticeService;

@Controller
@RequestMapping("/customer")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	
	@RequestMapping("/notice")
	public String notice() {
		return "/customer/notice";
	}
	
	@RequestMapping("/notice_view")
	public ModelAndView notice_view() {
		
		ArrayList<NoticeDto> list = noticeService.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("/customer/notice_view");
		return mv;
		
	}
	
	
}
