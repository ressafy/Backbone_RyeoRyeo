package index_create;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class indexCreater {
	// # 이름을 갖다 넣어야 함.
	public static void main(String[] args) throws Exception{
		String path = "./readme.txt";
		String path2 = "./result.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		BufferedWriter bw = new BufferedWriter(new FileWriter(path2));
		StringBuilder sb1;
		StringBuilder sb2;

		String temp,na;
		char [] arr;
		
		
		while((temp = br.readLine())!=null) {
			System.out.println(temp);
			if(temp.charAt(0) == '#' && temp.charAt(1) != '#') {
				sb1 = new StringBuilder();
				sb2 = new StringBuilder();
				int a = temp.length();
				arr = new char[a];
				sb1.append('[');
				for (int i = 2; i < a; i++) {
					sb2.append(temp.charAt(i));
				}
				sb1.append(sb2).append("](#");
				na = sb2.toString();
				na.replace(" ", "-");
				System.out.println(na);
				sb1.append(na).append(")<br>");
				bw.write(sb1.toString());
				System.out.println(sb1.toString());
			}
		}
	}

}
