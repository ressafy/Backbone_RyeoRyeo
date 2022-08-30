package com.ssafy.jes.service;

import java.util.List;

import com.ssafy.jes.dao.HouseDAO;
import com.ssafy.jes.dao.HouseDAOImpl;
import com.ssafy.jes.dto.HouseInfo;

public class HouseServiceImpl implements HouseService{
	
	HouseDAO houseDao;
	
	public HouseServiceImpl() {
		houseDao=new HouseDAOImpl();
	}

	@Override
	public List<HouseInfo> searchAll() {
		return houseDao.searchAll();		
	}

}
