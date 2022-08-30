package 과목평가3회차출제;
import java.util.Scanner;

public class Algo2_도시_반_이름 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      char[] crr = s.toCharArray();
      String result = "";
      String check = "aeiou";
      for(int i =0; i <crr.length; i++) {
         result += crr[i];
         if(check.contains(crr[i]+"")) {
            i += 2;
         }
      }
      System.out.println(result);
   }
}