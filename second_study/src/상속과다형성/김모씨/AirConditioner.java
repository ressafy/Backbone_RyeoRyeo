package 상속과다형성.김모씨;

public class AirConditioner{
	private String windDir = "정방향";
	private int temper = 30;
	
	
	public int normal() {
		System.out.println("일반 냉방으로 전환합니다.");
		return this.temper -= 1;
	}
	
	public int power() {
		System.out.println("파워 냉방 모드로 전환합니다.");
		return this.temper -= 2;
	}
	
	public String changeWindDir(String n) {
		return this.windDir = n;
	}

	
}
