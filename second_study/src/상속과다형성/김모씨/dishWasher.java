package 상속과다형성.김모씨;

import java.awt.DisplayMode;

public class dishWasher implements electric,Device{
	private boolean dooropened = false;
	private int dishSpace = 10;
	private boolean powered = false;
	final String name = "dishWasher";
	
	public int getDishSpace() {
		return dishSpace;
	}


	public void setDishSpace(int dish) {
		this.dishSpace -= dish;
	}


	
	public String getName() {
		return name;
	}


	public void insertDish() {
		if (this.dooropened == true && this.dishSpace > 0) {
			setDishSpace(1);
			System.out.println("접시를 넣었습니다. 빈 공간 수: "+getDishSpace());
			
			
		}else if (this.dooropened == false) {
			System.out.println("문을 열어 주세요");
		}else if (this.dishSpace <=0) {
			System.out.println("접시를 빼주세요");
		}
	}
	
	public void outDish() {
		if(this.dishSpace != 10) {
			setDishSpace(-1);
		}
	}

	@Override
	public void wash() {
		if(powered == true) {
			dish d = new dish();
			System.out.println("접시를 닦습니다.");
			d.setSteamed(true);
			System.out.println("접시 살균상태: "+d.isSteamed());
		}else {
			System.out.println("작동을 하지 않는다.");
		}
		
	}

	@Override
	public void d_open() {
		if (this.dooropened == false) {
			System.out.println("문을 엽니다.");
			this.dooropened = true;
		}else {
			System.out.println("이미 열려있습니다.");
		}
		
	}


	@Override
	public void d_close() {
		if(this.dooropened == true) {
			System.out.println("문을 닫습니다.");
			this.dooropened = false;
		}else {
			System.out.println("이미 닫혀있습니다.");
		}
		
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
