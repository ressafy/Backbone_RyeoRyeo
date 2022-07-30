package com.ssafy.rent.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.sound.midi.MidiDevice.Info;



/**
 * CSV 파일 입출력
 * csv 파일은 comma Separated Values
 * 몇가지 필드를 쉼표(,)로 구분한 텍스트 데이터 및 텍스트 파일이다.
 * 확장자는 .csv이고 mime형식은 text/csv이다.
 * D:/D_Other/ejyooCSVFiles.csv
 * @author ejyoo
 *
 */


public class ConvenientCSVparser {
	
	public static void main(String[] args) {
		File f = new File("res/convenient.csv");
		String [][]conv_list = new String [3][];
		if(f.exists()) {
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(f), "UTF-8"))) {
				 String line=null;
				 reader.readLine();
	             while((line=reader.readLine()) != null) {
	            	 String[] info = line.split(",");
	            	 System.out.print(info[15]);
	            	 System.out.print(info[18]);
	            	 System.out.println(info[22]);
	            	 
	             }
			} catch (Exception e) {
				System.out.println(e);
			}
			// 6:영업상태  15:주소  18:이름  22:업종
		
			
//		BufferedReader br = null;
//		String line;
//		String path = "res/convenient.csv";
//		try {
//			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
//			//br = new BufferedReader(new FileReader(path)); // 이렇게도 가능
//			while((line = br.readLine()) != null) {
//				//String[] temp = line.split("\t"); // 탭으로 구분
//				String[] temp = line.split(","); // 쉼표로 구분
//				for(int i=0; i<temp.length; i++) {
//					System.out.print((i+1)+"열: "+temp[i]);
//					if(i!=temp.length-1) System.out.print(", ");
//					else System.out.println();
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
}
