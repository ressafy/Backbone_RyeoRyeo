package test6.interface_;

public abstract class Vehicle {  // 하위클래스 사용하거나 해라
	private String from, to;
	
	public abstract void move(String from,String to);

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
}
