package shape;

public class Printer {
	public void print(Shape o) {
		o.area();
	}
	
	public void print(Circle c) {
		System.out.println("원의 반지름"+ ++c.r);
	}
}

