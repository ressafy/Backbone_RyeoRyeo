package test8.exception;

public class Service {
	public static void divide(int x, int y) throws MyException, NumberFormatException{  // exception 상황 발생하면 정상적인 리턴이 되지 않는다.
//		try {System.out.println(x/y);
//		}catch(ArithmeticException e){
//			System.out.println("0을 입력하지 마세요");
//		}  // 그렇게 되면 메인에서는 제대로 작동했는지 아닌지 모른다. -> 비정상 상황에 대한 리턴! -> throws 이다.
//		
		if(y==0) {
			throw new MyException("0을 입력하지 마세요");
		}
		System.out.println(x/y);  // main 에 throws 써놓고 이렇게만 해주면 
	}
}
