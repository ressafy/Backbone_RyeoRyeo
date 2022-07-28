package com.ssafy.live5.io.node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class UseFileStream {
    public static void main(String[] args) throws IOException {
        UseFileStream st = new UseFileStream();
        st.testFile();

         System.out.printf("buffer size: %d, time: %d%n", 100, st.fileMove(100));  // 내꺼는 2초 드네
        // System.out.printf("buffer size: %d, time: %d%n", 1000, st.fileMove(1000));
        // System.out.printf("buffer size: %d, time: %d%n", 10000, st.fileMove(10000));  // 갈수록 시간이 단축된다.
        // System.out.printf("buffer size: %d, time: %d%n", 100000, st.fileMove(100000));  // 그렇다고 무한대로 늘릴 수는 없다. 처리할 수 있는 양이 있으니
        // System.out.printf("buffer size: %d, time: %d%n", 1000000, st.fileMove(1000000));
    }


    private void testFile() throws IOException {
        // 절대 경로
        File temp = new File("c:\\Temp");
        System.out.printf("존재? %b, 디렉토리? %b%n", temp.exists(), temp.isDirectory());

        // 상대경로
        File current = new File(".");  // . 운 현재 경로 디렉토리 자바라는 것을 실행시킨 위치이다.
        System.out.printf("여기는 어디? %s%n", current.getCanonicalPath());
        
        // 상대경로의 기준은 java program을 실행하는 위치(소스와 무관)
        //d:\>java -cp .;c:\SSAFY\workspace\java\live\bin com.ssafy.live5.io.node.UseFileStream
        //c:\SSAFY\workspace\java\live\bin>java com.ssafy.live5.io.node.UseFileStream
        
        // TODO: readme.txt에 해당하는 File 객체를 만들어 보자.
        //  프로젝트와 무관하게 파일을 찾을 때
        File readMe = new File("c:\\0_SSAFY\\2_workspace\\1_java\\java_ssafy_8th_l\\bin\\com\\ssafy\\live5\\io\\node\\readme.txt");
        //  프로젝트 내부에서 파일을 찾을 때
        readMe = new File(".\\bin\\com\\ssafy\\live5\\io\\node\\readme.txt");  // 이렇게 bin 파일을 기준으로 해야하고 저 .은 좀 위험하다.
        //  특정 클래스 기준으로 파일을 찾을 때
        readMe = new File(UseFileStream.class.getResource("readme.txt").getFile());
        System.out.println(readMe.getCanonicalPath());
        // END:
    }

    public long fileMove(int bufferSize) {
        long start = System.currentTimeMillis();
        // TODO: 본인의 컴퓨터에서 크기가 큰 파일을 선택하세요.
        File src = new File("c:\\java_hw_07_2-master.zip");
        File target = new File("c:\\Temp\\eclipse.zip");
        // TODO: bufferSize 크기의 byte []을 이용해서 src를 target에 복사하시오.
        try(FileInputStream fin = new FileInputStream(src);
                FileOutputStream fout = new FileOutputStream(target);){
        	byte[] buffer = new byte[bufferSize];
        	int read = 0;
        	while((read = fin.read(buffer)) > 0) {
        		fout.write(buffer,0,read);
        	}
        	
        } catch(IOException e) {
        	e.printStackTrace();
        }
        
        // END:
        return System.currentTimeMillis() - start;
    }
}
