package test4.constructor;

import test1.datatype.Myprofile;

public class ShoppingMallService {

	public static void main(String[] args) {
		Myprofile m1 = new Myprofile(28,165.0,'남',false,"안려환");
		
		Myprofile m2 = new Myprofile(40,150.0,'여',true,"전지현");
		
		Myprofile m3 = new Myprofile(43,160.0,'여',true,"전도연");
	
		Myprofile m4 = new Myprofile();
	}

}
