package 상속과다형성.김모씨;

public class dishWasher {
	private boolean dooropened = false;
	private int dishSpace = 10;
	
	public void doorOpen() {
		this.dooropened = false;
	}
	
	public void insertDish() {
		if (this.dooropened == true && this.dishSpace > 0) {
			System.out.println("접시를 넣었습니다.");
			this.dishSpace -= 1;
		}else if (this.dooropened == false) {
			System.out.println("문을 열어 주세요");
		}else if (this.dishSpace <=0) {
			System.out.println("접시를 빼주세요");
		}
	}
	
	public void dishWork(dish d) {
		System.out.println("그릇을 세척합니다.");
		d.setSteamed(true);
		System.out.println("그릇을 살균합니다. 살균상태: "+d.isSteamed());
		
	}
}
