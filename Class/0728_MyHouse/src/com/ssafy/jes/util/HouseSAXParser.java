package com.ssafy.jes.util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.jes.dto.HouseInfo;

public class HouseSAXParser extends DefaultHandler{
	
	HouseInfo h;
	String temp;
	
	List<HouseInfo> list;
	
	public HouseSAXParser() {
		list=new LinkedList<>();
		SAXParserFactory factory=SAXParserFactory.newInstance();
		try {
			SAXParser p=factory.newSAXParser();
			p.parse("res/AptDealHistory.xml", this);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<HouseInfo> loadData(){
		return list;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("item")) {
			h=new HouseInfo();
			list.add(h);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("거래금액")) {
			h.setPrice(temp);
		}else if(qName.equals("법정동")) {
			h.setDong(temp);
		}else if(qName.equals("아파트")) {
			h.setAptName(temp);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		temp=new String(ch,start,length);
	}

}















