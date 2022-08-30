import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String ch=s.next();
		switch(ch) {
			case "1":
				int n=1;
				for (int i=1; i<=4; i++) {
					for(int j=1; j<=i; j++) {
						System.out.print(n++ + " ");
					}
					System.out.println();
				}
				break;
		case  "*":
				for (int i=1; i<=5; i++) {
					for(int j=1; j<=(5-i); j++) {
						System.out.print("  ");
					}
					for(int j=1; j<=i; j++) {
						System.out.print("* ");
					}
					System.out.println();
				}
				break;
		case  "A":
			char  c='A';
			for (int i=1; i<=5; i++) {
				for(int j=1; j<=(5-i); j++) {
					System.out.print("  ");
				}
				for(int j=1; j<=i*2-1; j++) {
					System.out.print(c++ + " ");
				}
				System.out.println();
			}
		}
	}

}
