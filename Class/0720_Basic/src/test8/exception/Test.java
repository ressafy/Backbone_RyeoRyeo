package test8.exception;

public class Test {

	public static void main(String[] args) {  // 로버스터이다. (작은 에러는 복구 가능)
		try {  // exception 처리 방법 1. try & catch
			int x = 100, y = Integer.parseInt(args[0]);  // parse 는 문자열형태의 수를 수의 형태로 바꿔주는 것
			System.out.println(x/y);
		}catch (ArrayIndexOutOfBoundsException e) {  // 여기의 e가 다형성 적용이 되나 -> 반드시 Throwable 하위 객체로 arg 적용할 수 있다.
			// 복구코드가 들어가야 한다.
			System.out.println("실행시 아규먼트 넣어주세요");  // 하지만 편리함을 위해 Throwable 로 하면 아래 다른 에러에 대한
			 										// exception 발생했을 때 여기서 걸려서 안좋다. -> 치명적 보안적 담점이 되기도 한다.
		}catch(ArithmeticException e) {
			System.out.println("0을 입력하지 마세요");
		}catch(NumberFormatException e) {
			System.out.println("숫자 포맷으로 연결하세요");
		}catch(Exception e) {  // catch는 아래로 내려갈 수록 상위 메서드로 구성되게 해야 한다.
			// 일괄 복구 코드
			System.out.println(e.getMessage()+" 익셉션발생");
		}	// 이게 끝나면  exception 객체도 gc가 치워버린다. 그 메소드는 그대로 있지만
		System.out.println("더 중요한 일...");
	}

}
