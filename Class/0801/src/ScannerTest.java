import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("우리는 몇 기?");
		int no = sc.nextInt();
		System.out.println("우리는 SSAFY "+no+"기");
		System.out.println("우리를 대표하는 한 마디?");
		sc.nextLine();
		String msg = sc.nextLine();
		System.out.println("우리를 대표하는 한 마디는 "+msg);
		
		
	}

}
