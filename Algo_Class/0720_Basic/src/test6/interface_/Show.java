package test6.interface_;

public class Show {
	public static void airShow(Flyer f) {
		f.fly();
	}
	
	public static void airShow(Bird b) {
		b.fly();
		b.eat();
	}
	
	public static void readyShow() {
		Flyer.repairWing();
		// 2. Flyer.repairWing();
		// interface 의 이름
		//1. 여기는 f.repairWong(); 으로 써야 한다.
	}
}
