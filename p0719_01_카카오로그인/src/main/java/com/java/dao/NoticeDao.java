package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.NoticeDto;

@Mapper
public interface NoticeDao {

	NoticeDto selectAll();


}
