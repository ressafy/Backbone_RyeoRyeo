import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Template {
    //(default) static data
    //(default) static method

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("Test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] oneLineArr=br.readLine().split(" ");

        // StringBuilder resultStr=new StringBuilder();
        //resultStr.append("xxx");

        // 배열 초기화 시에 new 보다 Collections.fill(0);

}
}