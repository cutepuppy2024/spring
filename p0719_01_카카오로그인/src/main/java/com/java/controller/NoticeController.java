package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dao.NoticeDao;
import com.java.dto.NoticeDto;
import com.java.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired NoticeService noticeService;
	
	@RequestMapping("/customer/notice")
	public ModelAndView notice() {

		// 게시판 리스트 전체 불러오기
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		
		NoticeDto nDto  =  noticeService.selectAll();

		ModelAndView mv =  new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("customer/notice");

		return mv;	
	}

}
