package test6.interface_;

public interface Flyer {
	public void fly() ;
	
	static public void repairWing() {
		System.out.println(">>>날개를 수리합니다.");
	}  // 다른 클래스에 영향을 끼치지 않게 하려고
	// 1. 여기가 default 면 
	// 2. 여기가 static public void repairWing() 이면
}
