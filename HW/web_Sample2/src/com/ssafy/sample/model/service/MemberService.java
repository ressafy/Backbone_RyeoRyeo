package com.ssafy.sample.model.service;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.model.dao.MemberDAO;

public class MemberService {
	MemberDAO memberDao;
	private static MemberService instance;

	public Member login(String id, String pw) {
		return memberDao.login(id,pw);
	}

	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		return instance;
	}

	

}
