package member.dto;

public class SecVO {
    private String userId;
    private String salt;
    private String secKey;
    
    public SecVO() {}
	public SecVO(String userId, String salt, String secKey) {
		super();
		this.userId = userId;
		this.salt = salt;
		this.secKey = secKey;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		if(userId != null) {
			this.userId = userId;
		}
		
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		if(salt != null) {
			this.salt = salt;
		}
		
	}
	public String getSecKey() {
		return secKey;
	}
	public void setSecKey(String secKey) {
		if(secKey != null) {
			this.secKey = secKey;
		}
		
	}

	
}
