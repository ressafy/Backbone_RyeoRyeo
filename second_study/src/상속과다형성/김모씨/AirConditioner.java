package 상속과다형성.김모씨;

 class  AirConditioner implements Device{
	private String windDir = "정방향";
	private int temper = 30;
	
	
	public String getWindDir() {
		return windDir;
	}


	public int getTemper() {
		return temper;
	}


	public void normal() {
		System.out.println("일반 냉방으로 전환합니다.");
		this.temper -= 1;
		System.out.println("현재 온도: "+getTemper()+"바람방향: "+getWindDir());
	}
	
	public void power() {
		System.out.println("파워 냉방 모드로 전환합니다.");
		this.temper -= 2;
		System.out.println("현재 온도: "+getTemper() +"바람방향: "+getWindDir());
	}
	
	public String changeWindDir(String n) {
		return this.windDir = n;
	}

	
}
