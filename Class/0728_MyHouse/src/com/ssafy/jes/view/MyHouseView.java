package com.ssafy.jes.view;

import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import com.ssafy.jes.dto.HouseInfo;
import com.ssafy.jes.service.HouseService;
import com.ssafy.jes.service.HouseServiceImpl;

public class MyHouseView {
	JFrame f;
	JTable table;
	
	HouseService houseService;
	DefaultTableModel model;
	String[] columnNames= {"번호","동","아파트명","거래금액"};
	
	public MyHouseView() {
		setMain();
		showHouses();
	}
	
	private void setMain() {
		houseService=new HouseServiceImpl();
		
		f=new JFrame("주택거래정보");
		
		model=new DefaultTableModel(columnNames,20);
		table=new JTable(model);
		JScrollPane scroll=new JScrollPane(table);
		
		f.add(scroll);
		
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	

	private void showHouses() {		
		List<HouseInfo> list=houseService.searchAll();
		System.out.println(list.size());
		int i=0;
		String[][] dataVector=new String[list.size()][4];
		for(HouseInfo h:list) {
			dataVector[i][0]=i+"";
			dataVector[i][1]=h.getDong();
			dataVector[i][2]=h.getAptName();
			dataVector[i++][3]=h.getPrice();
		}
		
		model.setDataVector(dataVector, columnNames);
	}

}





