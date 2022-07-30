package com.ssafy.rent.util;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.temporal.TemporalAccessor;
import java.io.FileInputStream;
import java.io.IOException;

import com.ssafy.rent.model.dto.EnvPollution;

public class EnvPollutionImpl {

	private List<EnvPollution> envPollutionInfo;

	public static void main(String[] args) {
		EnvPollutionImpl s= new EnvPollutionImpl();
	}

	
	public EnvPollutionImpl() {
		envPollutionInfo= new LinkedList<EnvPollution>();
		fileLoad();
	}
	
	private void fileLoad() {
		File file = new File("res"+File.separator+"서울시 시간 평균 대기오염도 정보.csv");
		if(file.exists()) {
			try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), "MS949"))) {
				 String line=null;
				 reader.readLine();
	             while((line=reader.readLine()) != null) {
	            	 String[] getinfo = line.split(",");
	            	 System.out.println(Arrays.toString(getinfo));
	            	 if (getinfo.length==8) {
	            		 envPollutionInfo.add(new EnvPollution(getinfo[0],getinfo[1],getinfo[2],getinfo[3],getinfo[4],getinfo[5],getinfo[6],getinfo[7] ));	 
	            	 }     	

	             }
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public List<EnvPollution> getEnvList(String name){
		List<EnvPollution> tmp = new LinkedList<EnvPollution>();
		for (int i = 0, end = envPollutionInfo.size(); i < end; i++) {
			if(envPollutionInfo.get(i).getName().contains(name)){
				tmp.add(envPollutionInfo.get(i));
			}
		}
		return tmp;
	}
	
	public List<EnvPollution> getEnvList(){
		return envPollutionInfo;
	}

	
}
