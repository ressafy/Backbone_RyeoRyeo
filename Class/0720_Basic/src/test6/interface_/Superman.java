package test6.interface_;

public class Superman extends Person implements Flyer{
	@Override
	public void eat() {
		System.out.println("샌드위치를 좋아한다.");
		super.eat();
	}
	
	@Override
	public void fly() {
		System.out.println("망토를 휘날리며 난다...");
	}
	
//	@Override
//	public void repairWing() {
//		System.out.println(">>>망토를 수리한다.");
//	}
}

