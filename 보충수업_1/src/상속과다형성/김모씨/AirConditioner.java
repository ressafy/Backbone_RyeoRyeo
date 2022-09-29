package 상속과다형성.김모씨;

 class  AirConditioner implements Device{
	private String windDir = "정방향";
	private int temper = 30;
	private boolean powered = false;
	final String name = "AirConditioner";
	
	public String getWindDir() {
		return windDir;
	}


	public int getTemper() {
		return temper;
	}

	

	public String getName() {
		return name;
	}



	public void normal() {
		if(powered == true) {
			System.out.println("일반 냉방으로 전환합니다.");
			this.temper -= 1;
			System.out.println("현재 온도: "+getTemper()+" 바람방향: "+getWindDir());
		}else {
			System.out.println("작동을 하지 않는다.");
		}
		
	}
	
	public void power() {
		if(powered == true) {
			System.out.println("파워 냉방 모드로 전환합니다.");
			this.temper -= 2;
			System.out.println("현재 온도: "+getTemper() +" 바람방향: "+getWindDir());
		}else {
			System.out.println("작동을 하지 않는다.");
		}
		
	}
	
	public String changeWindDir(String n) {
		return this.windDir = n;
	}


	@Override
	public void on() {
		if(this.powered == false) {
			System.out.println(getName()+"전원을 킵니다.");
			this.powered = true;
		}else {
			System.out.println("이미 켜져있읍니다...");
		}
		
	}

	@Override
	public void off() {
		if(this.powered == true) {
			System.out.println(getName()+"전원을 끕니다.");
			this.powered = false;
		}else {
			System.out.println("이미 꺼져있읍니다...");
		}
		
	}

	
}
