package test8.exception;

public class Test_1 {

	public static void main(String[] args){  // 여러 가지 익셉션 넣어봤자 의미 없다. 메인에 쓸 때는 그냥 Exception
		int x = 100, y = Integer.parseInt(args[0]);
		try {
			Service.divide(x, y);
			
		} catch (MyException e) {
			// getMessage 쓰는건 보안에 심각하게 위배된다.
			// 복구 코드를 써야 한다.
			System.out.println(e.getMessage());
		} catch(NumberFormatException e) {
			// 복구 코드를 써야 한다.
			System.out.println(e.getMessage());
		} finally {
			// 반드시 실행되어야 한다면 finally 로 넣어줘야 한다.
			System.out.println("divide 후에 반드시 해야할 일");
		}
		
		System.out.println("더 중요한 일...");

	}

}
