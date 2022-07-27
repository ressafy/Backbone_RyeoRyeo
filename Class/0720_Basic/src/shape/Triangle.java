package shape;

public class Triangle extends Shape{
	int w =3, h=4;
	public void area() {
		System.out.println("삼각형의 넓이"+(w*h/2));
	}
}
