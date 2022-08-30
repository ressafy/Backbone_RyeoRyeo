package 기본문법;

public class DigitTest {

	public static void main(String[] args) {
		int count = 0 ,length = 5;
		for(int i =0;i<length;i++) {
			for(int j=0; j<i; j++) {
				System.out.print("   ");
			}
			
			for(int k=0; k<length-i; k++) {
				count += 1;
				if(k==length-i-1) {
					System.out.print(count);
				}else {if(i<2) {
					System.out.print(count+"  ");
				}else{System.out.print(count+" ");}}
			}
			System.out.println();
		}
	}
}