package 상속과다형성.김모씨;

public class dishWasher implements electric{
	private boolean dooropened = false;
	private int dishSpace = 10;
	
	
	
	public int getDishSpace() {
		return dishSpace;
	}


	public void setDishSpace(int dish) {
		this.dishSpace -= dish;
	}


	public void insertDish() {
		if (this.dooropened == true && this.dishSpace > 0) {
			System.out.println("접시를 넣었습니다. 빈 공간 수: "+getDishSpace());
			setDishSpace(1);
			
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
		dish d = new dish();
		System.out.println("접시를 닦습니다.");
		d.setSteamed(true);
		System.out.println("접시 살균상태: "+d.isSteamed());
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
}
