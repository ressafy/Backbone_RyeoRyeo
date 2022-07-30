package com.ssafy.rent.model.service;

import java.util.List;

import com.ssafy.rent.model.dto.EnvPollution;
import com.ssafy.rent.util.EnvPollutionImpl;

public class EnvPollutionServiceImpl {
	private EnvPollutionImpl envpDao;
	
	public EnvPollutionServiceImpl() {
		envpDao=new EnvPollutionImpl();
	}
	
	public List<EnvPollution> search(String dong) {
	
		return envpDao.getEnvList(dong);
	}
	public List<EnvPollution> search() {
		return envpDao.getEnvList();
	}
}
