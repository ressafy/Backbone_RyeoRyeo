package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
    	NormalBox n = new NormalBox();
    	n.setSome(1);  // object 로 받았기에 가능
    	n.setSome("Hello");
    	
    	Object obj = n.getSome();
    	if(obj instanceof String) {   // 타입 체킹 성능에 심각한 영향을 준다.
    		String str = (String)obj;
    		System.out.println(str+" : "+str.length());
    	}
        // END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
    	GenericBox<String> sbox = new GenericBox<>();
    	sbox.setSome("Hello");
//    	sbox.setSome(1);  // 컴파일하면서 타입에 대한 체크
    	String str = sbox.getSome();  // 타입 체킹을 안해도 된다.
    	System.out.println(str+" : "+str.length());
        // END:
    	
    	GenericBox<Integer> ibox = new GenericBox<>(); // 이렇게 하면 인테저만 받을 수 있게!
    	ibox.setSome(1);
    	
    	GenericBox<Object> obox = new GenericBox<>();
    	obox.setSome("Hello");
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
    	NumberBox<Number> numbox = new NumberBox<>();
    	numbox.addSome(1,10L,3.14);
    	
    	NumberBox<Integer> dbox = new NumberBox<>();
    	dbox.addSome(1,3,10);
        // END:
    }

}
