package com.ssafy.jes.dao;

import java.util.List;

import com.ssafy.jes.dto.HouseInfo;
import com.ssafy.jes.util.HouseSAXParser;

public class HouseDAOImpl implements HouseDAO {
	
	HouseSAXParser parser;
	
	public HouseDAOImpl() {
		parser=new HouseSAXParser();
	}

	@Override
	public List<HouseInfo> searchAll() {
		return parser.loadData();
		
	}

}
