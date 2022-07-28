package com.ssafy.live5.io.node;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class SimpleInputTest {

    private String data1 = "hi java world";
    private String data2 = "자바는 객체지향 언어입니다.";

    private void read1() {
        // TODO: data2를 읽어보자.
        try (InputStream input = new ByteArrayInputStream(data1.getBytes())) {  // 넣는 이유는 나중에 자동으로 close 하기 위해서 넣는다. 바어인 값은 data.getBytes()로 가져옴
            int read = -1;  // 더 이상 넣을 데이터가 없으면 그냥 -1이면 끝난다는 것을 보여주기 위해서 넣었다.
            while ((read = input.read()) != -1) {
                System.out.printf("읽은 값: %d, 문자로: %c%n", read, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unused")
    private void read2() {
        byte[] buffer = new byte[10];
        try (InputStream input = new ByteArrayInputStream(data2.getBytes())) {
            int read = -1;
            while ((read = input.read(buffer)) > 0) {  // 버퍼의 사이즈만큼 읽어온 다음에
                System.out.printf("읽은 개수: %d, 문자열: %s%n", read, new String(buffer, 0, read)); // 0번부터 read 까지ㅏ 읽어오라. 인덱스(-1)값
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private void read3() {
        char[] buffer = new char[10];
        // TODO: CharReader를 이용해 data2를 읽고 출력하시오.
        try (Reader input = new CharArrayReader(data2.toCharArray());) {
        	int read = -1;
        	while((read = input.read(buffer))>0) {
        		System.out.println("읽은 개수: "+read+", 문자열로는 "+new String(buffer, 0, read));
        	}
			input.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
        // END:
    }

    public static void main(String[] args) {
        SimpleInputTest ns = new SimpleInputTest();
        //ns.read1();
        // ns.read2();
         ns.read3();
    }
}
