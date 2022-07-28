package test3.array;

public class Test3 {  // eden 공간에 3자리의 배열이 바로 만들어 진다. 그리고 누군가 올려준 오브젝트의 11개 메서드를 링크하는 것을 JVM에 의해 자동으로
						// 100 번지 주소를 할당받고 stack 의 main 에 all 에 100번지를 링크하게 된다.

	public static void main(String[] args) {
		int [] all = new int [3];

		System.out.println(all);
	}

}
