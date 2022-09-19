package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao = new MemberDaoImpl();
	
	private DBUtil dbutil;
	
	
	private MemberDaoImpl() {
		dbutil= DBUtil.getInstance();
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int idCheck(String userId) throws SQLException {
		int cnt = 100;  // 이거는 0이 가능하다.
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = dbutil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(user_id) \n");
			sql.append("from members \n");
			sql.append("where user_id = ?");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			rs.next();
			cnt=rs.getInt(1);
		}finally {
			dbutil.close(rs,stmt,conn);
		}
		
		return cnt;
	}

	@Override
	public int joinMember(MemberDto memberDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
