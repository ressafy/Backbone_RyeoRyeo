
public class StringTest {

	public static void main(String[] args) {
		String s1 = "java";
		s1 = s1+ " study";
		String s3 = s1.concat(" study");
		// 위보다 concat이 나은 이유는 위는 +라는 연산을 자동으로 하기에 일을 더 하게 된다.
		
		StringBuffer sb1 = new StringBuffer("java");
		sb1.append(" study");
		// StringBuffer 는 꼭 new 를 써서 해야한다.
		// 에초에 16공간이 있어서 지금 자바 스터디 해도 6공간이 남아있다.
		// 이후에 이 공간이 넘어가면 32로 2배씩 늘려 생성해서 기존꺼에서 옮겨간다.
		// 원본의 변경이 일어난다.
		StringBuilder stb1 = new StringBuilder("java");
		stb1.append(" study");
		System.out.println(stb1);
	}

}
