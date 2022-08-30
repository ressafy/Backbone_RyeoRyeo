package test6.interface_;

public class Airplane extends Vehicle implements Flyer {
	public void move() {
		flying(getFrom(),getTo());
	}
	
	@Override
	public void move(String from, String to) {
		flying(from,to);
	}
	
	public void flying(String from, String to) {
		setFrom(from);
		setTo(to);
		System.out.println("엔진을 가동해서 난다....");
	}
	
	@Override
	public void fly() {
		flying(getFrom(),getTo());
		
	}
}
