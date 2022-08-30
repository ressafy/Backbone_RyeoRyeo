package test6.interface_;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird b = new Bird();
		Superman s = new Superman();
		Airplane a = new Airplane();
		
		Flyer allFlyer[] = new Flyer[3];
		allFlyer[0] = b;
		allFlyer[1] = s;
		allFlyer[2] = a;
		
		
		for(Flyer f :allFlyer) {
			Show.readyShow();
			Show.airShow(f);
		}
		
	}

}
