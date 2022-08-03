package 상속과다형성.김모씨;

public class drumWasher implements electric,Device{
	private boolean dry = false;
	private boolean dooropened = false;
	private boolean powered = false;
	
	
	public boolean isPowered() {
		return powered;
	}


	public boolean isDry() {
		return dry;
	}

	public void setDry(boolean dry) {
		this.dry = dry;
	}

	@Override
	public void wash() {
		if(this.dooropened == false) {
			System.out.println("세탁기가 돌아갑니다.");
			setDry(true);
			System.out.println("탈수까지 완료 탈수 상태: "+isDry());
		}else {
			System.out.println("문을 닫고 돌려주세요");
		}
		
		
		
	}

	@Override
	public void d_open() {
		if(this.dooropened == false) {
			System.out.println("문을 엽니다.");
			this.dooropened = true;
		}else {
			System.out.println("이미 열려 있습니다.");
		}
		
	}

	@Override
	public void d_close() {
		if(this.dooropened == true) {
			System.out.println("문을 닫습니다.");
			this.dooropened = true;
		}else {
			System.out.println("이미 닫혀 있습니다.");
		}
		
	}

	@Override
	public void on() {
		if(this.powered == false) {
			System.out.println("전원을 킵니다.");
			this.powered = true;
		}else {
			System.out.println("이미 켜져있읍니다...");
		}
		
	}

	@Override
	public void off() {
		if(this.powered == true) {
			System.out.println("전원을 끕니다.");
			this.powered = false;
		}else {
			System.out.println("이미 꺼져있읍니다...");
		}
		
	}

}
