package member.service;

import java.util.UUID;

import member.controller.OpenCrypt;
import member.dao.MemberDao;
import member.dto.Member;
import member.dto.SecVO;

public class MemberService {
	MemberDao memberDao;
	
	private static MemberService instance;
	private MemberService() {
		memberDao = MemberDao.getInstance();
	}
	public static MemberService getInstance() {
		if(instance== null) instance = new MemberService();
		return instance;
	}
	public Member login(String id, String pw) {
		Member m = findMember(id);
		System.out.println(m.getPw());
		return memberDao.login(id, m.getPw());
	}
	
	public int memberInsert(Member member) {
		return memberDao.insertMember(member);
	}
	
	
	
	// 추가된 부분
	// memberDao 에 updateMember selectMember insertSecurity 
  
	// 1: 회원가입실패 - 이유 기존 회원 존재 2: 에러발생 3: 회원가입 성공
	public int addMember(Member memberModel) {
		if ( memberDao.selectMember(memberModel.getId()) != null ) {
			return 1;
		} else {
		           try {
		        	   byte[] key=OpenCrypt.generateKey("AES",128);
		        	   System.out.println("key length:"+key.length);
		        	   SecVO sec=
new SecVO(memberModel.getId(),UUID.randomUUID().toString(),OpenCrypt.byteArrayToHex(key));
		        	   memberDao.insertSecurity(sec);
		        	   memberModel.setName(OpenCrypt.aesEncrypt(memberModel.getName(), key));
		        	   String pw = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(memberModel.getPw(), sec.getSalt()));
		               memberModel.setPw(pw);    
		               memberDao.insertMember(memberModel);		                   
		                   return 3;
		           }catch(Exception e ){
		        	  e.printStackTrace();
			               return 2;
		           }
		}
	}
	
	public Member findMember(String userId ) {
		Member m=memberDao.selectMember(userId);
		SecVO sec=memberDao.selectSecurity(userId);
		try {
			m.setName(OpenCrypt.aesDecrypt(m.getName(), 
					OpenCrypt.hexToByteArray(sec.getSecKey())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	
	
}

