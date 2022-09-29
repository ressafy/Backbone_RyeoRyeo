package com.ssafy.test.model.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.dto.Note;
import com.ssafy.test.util.DBUtil;

public class NoteDaoImpl implements NoteDao {

	private NoteDaoImpl() {}
	private static NoteDaoImpl instance = new NoteDaoImpl();
	public static NoteDaoImpl getInstance() {
		return instance;
	}
	
	private DBUtil dbUtil = DBUtil.getInstance();
	
	
	/**
	 * 전체 목록 조회
	 */
	@Override
	public List<Note> selectAll() throws SQLException {
		List<Note> noteList = new ArrayList<>();
		String sql = "select noteCode, model, price, company from note";
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
					String noteCode = rs.getString("notecode");
					String model = rs.getString("model");
					int price = rs.getInt("price");
					String company = rs.getString("company");
					
					Note note = new Note();
					note.setNoteCode(noteCode);
					note.setModel(model);
					note.setPrice(price);
					note.setCompany(company);
					
					
					noteList.add(note);
				}
			}
		}
		
		return noteList;
	}


	@Override
	public Note selectByNoteCode(String noteCode) throws SQLException {
		String sql = "select noteCode, model, price, company from note where noteCode=?";
		Note note = null; 
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, noteCode);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					note = new Note();
					note.setNoteCode(rs.getString("noteCode"));
					note.setModel(rs.getString("model"));
					note.setPrice(rs.getInt("price"));
					note.setCompany(rs.getString("company"));
				}
			}
		}
		return note;
	}


	@Override
	public int insert(Note note) throws SQLException {
		String sql = "insert into note (noteCode, model, price, company) values (?, ?, ?, ?)";
		int cnt = 0;
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, note.getNoteCode());
			pstmt.setString(2, note.getModel());
			pstmt.setInt(3, note.getPrice());
			pstmt.setString(4, note.getCompany());
			
			cnt = pstmt.executeUpdate();
		}
		return cnt;
	}


	@Override
	public int update(Note note) throws SQLException {
		String sql = "update note set model=?, price=?, company=? where noteCode=?";
		int cnt = 0;
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, note.getModel());
			pstmt.setInt(2, note.getPrice());
			pstmt.setString(3, note.getCompany());
			pstmt.setString(4, note.getNoteCode());
			
			cnt = pstmt.executeUpdate();
		}
		return cnt;
	}


	@Override
	public int delete(String noteCode) throws SQLException {
		String sql = "delete from note where noteCode=?";
		int cnt = 0;
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, noteCode);
			
			cnt = pstmt.executeUpdate();
		}
		return cnt;
		
	}
	

}
