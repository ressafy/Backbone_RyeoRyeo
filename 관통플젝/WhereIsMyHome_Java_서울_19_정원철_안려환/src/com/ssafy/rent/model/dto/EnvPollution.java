package com.ssafy.rent.model.dto;

public class EnvPollution {

	private String time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	private String name;
	private String NO2;
	private String O3;
	private String CO;
	private String SO2;
	private String fd;
	private String ufd;

	public EnvPollution(String time,String name, String nO2, String o3, String cO, String sO2, String fd, String ufd) {
		setTime(time);
		setName(name);
		setNO2(nO2);
		setO3(o3);
		setCO(cO);
		setSO2(sO2);
		setFd(fd);
		setUfd(ufd);
		
	}
	
	public EnvPollution() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name!=null) {
			this.name = name;	
		}
		
	}
	public String getNO2() {
		return NO2;
	}
	public void setNO2(String nO2) {
		NO2 = nO2;
	}
	public String getO3() {
		return O3;
	}
	public void setO3(String o3) {
		O3 = o3;
	}
	public String getCO() {
		return CO;
	}
	public void setCO(String cO) {
		CO = cO;
	}
	public String getSO2() {
		return SO2;
	}
	public void setSO2(String sO2) {
		SO2 = sO2;
	}
	public String getFd() {
		return fd;
	}
	public void setFd(String fd) {
		this.fd = fd;
	}
	public String getUfd() {
		return ufd;
	}
	public void setUfd(String ufd) {
		this.ufd = ufd;
	}
	
	
	
	
	
	
	
}
