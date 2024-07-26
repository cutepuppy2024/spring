package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.NoticeDao;
import com.java.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired NoticeDao noticeDao;

	@Override
	public NoticeDto selectAll() {
		NoticeDto nDto = noticeDao.selectAll();
		return nDto;
	}

}
