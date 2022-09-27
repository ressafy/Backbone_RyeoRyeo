package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Note;
import com.ssafy.test.model.dao.NoteDao;
import com.ssafy.test.model.dao.NoteDaoImpl;

public class NoteServiceImpl implements NoteService {

	//싱글톤
	private NoteServiceImpl() {}
	private static NoteServiceImpl instance = new NoteServiceImpl();
	public static NoteServiceImpl getInstance(){
		return instance;
	}
	
	private NoteDao noteDao = NoteDaoImpl.getInstance();
	

	@Override
	public List<Note> selectAll() throws SQLException {
		return noteDao.selectAll();
	}

	@Override
	public Note selectByNoteCode(String noteCode) throws SQLException {
		return noteDao.selectByNoteCode(noteCode);
	}

	@Override
	public int insert(Note note) throws SQLException {
		return noteDao.insert(note);
	}

	@Override
	public int update(Note note) throws SQLException {
		return noteDao.update(note);
	}

	@Override
	public int delete(String isbn) throws SQLException {
		return noteDao.delete(isbn);
	}
	
}
