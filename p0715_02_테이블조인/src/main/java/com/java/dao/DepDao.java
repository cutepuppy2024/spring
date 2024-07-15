package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.DepDto;

@Mapper
public interface DepDao {

	ArrayList<DepDto> selectAll();
}
