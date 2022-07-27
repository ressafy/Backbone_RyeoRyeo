package shape;

public class Circle extends Shape{
	int r = 3;
	public void area() {
		System.out.println("원의 넓이:"+r*r*3.14);
	}
}
