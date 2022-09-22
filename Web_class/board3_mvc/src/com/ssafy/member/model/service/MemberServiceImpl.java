package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	
	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return memberDao.idCheck(userId);
	}

	@Override
	public void joinMember(MemberDto memberDto) throws Exception {
		// js 에서 validation check 를 했더라도 서버상에서 또 체크를 해야 한다. 클라이언트쪽에선 조작이 가능하기에
		memberDao.joinMember(memberDto);

	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
