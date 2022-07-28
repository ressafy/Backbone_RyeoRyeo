
import java.util.Calendar;

public class FormatStringTest {

	public static void main(String[] args) {
		Calendar validDate=Calendar.getInstance();
		validDate.set(2014,  Calendar.OCTOBER, 14);
		
		if(args.length <= 0) {
			System.out.println("Please Input Date (YYYY-MM-DD) !!!");
			return;
		}
		
		System.out.printf(args[0]+" did not match! HINT: It was issued on %1$terd of some month", validDate);

	}
	
//	public static void main(String[] args) {
//		Calendar validDate=Calendar.getInstance();
//		validDate.set(2014,  Calendar.OCTOBER, 14);
//		
//		if(args.length <= 0) {
//			System.out.println("Please Input Date (YYYY-MM-DD) !!!");
//			return;
//		}
//		
//		System.out.println(args[0]+" did not match! HINT: It was issued on "+ validDate.get(Calendar.DATE)+"rd of some month");
//
//	}
	

}