package com.java.service;

import java.util.ArrayList;

import com.java.dto.EmpDto;

public interface EmpService {
	// 사원정보 모두 가지오기
	ArrayList<EmpDto> selectAll();


}
