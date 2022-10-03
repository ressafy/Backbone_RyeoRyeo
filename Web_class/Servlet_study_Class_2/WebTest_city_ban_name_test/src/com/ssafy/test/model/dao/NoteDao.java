package com.ssafy.test.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Note;

public interface NoteDao {

	/**
	 * 노트북 전체 목록 조회
	 */
	List<Note> selectAll() throws SQLException;
	
	/**
	 * 노트북 상세 조회
	 */
	Note selectByNoteCode(String noteCode) throws SQLException;
	
	/**
	 * 노트북 정보 추가
	 */
	int insert(Note note) throws SQLException;
	
	/**
	 * 노트북 정보 수정
	 */
	int update(Note note) throws SQLException;
	
	/**
	 * 노트북 정보 삭제
	 */
	int delete(String noteCode) throws SQLException;

}
