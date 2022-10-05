package model;

public class MemberService {
	private MemberDAO memberDao; 
	
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		return instance;
	}
	private MemberService() {
		memberDao = MemberDAO.getInstance();
	}
	public Member login(String id, String pw) {
		memberDao.login(id,pw);
	}
}