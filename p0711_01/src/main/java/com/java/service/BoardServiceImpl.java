package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	// 게시글 전체리스트
	@Override
	public ArrayList<BoardDto> selectList() {

		ArrayList<BoardDto> list = boardDao.selectList();
		return list;
	}// selectList

	// 조회글 증가
	@Override
	public BoardDto selectOne(BoardDto bdto) {
		BoardDto boardDto = boardDao.selectOne(bdto);
		boardDao.updateBhit(bdto); // 조회수 1증가
		return boardDto;
	}

	// 게시글 작성
	@Override
	public void insertBoard(BoardDto bdto) {
		boardDao.insertBoard(bdto);
	}

	// 게시글 삭제
	@Override
	public void deleteBoard(BoardDto bdto) {
		boardDao.deleteBoard(bdto);
	}


	// 게시글 수정
	@Override
	public BoardDto updateBoard(BoardDto bdto) {
		BoardDto boardDto = boardDao.selectOne(bdto);
		return boardDto ;
	}
	
	
	// 게시글 수정저장
	@Override
	public void doUpdateBoard(BoardDto bdto) {
		boardDao.updateBoard(bdto);	
	}

	@Override // 답글페이지 저장
	public void insertReply(BoardDto bdto) {
		boardDao.updateBstep(bdto); // 부모보다 큰 step을 1씩 증가
		boardDao.insertBoard(bdto);		
	}

}
