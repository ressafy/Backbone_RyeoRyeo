package test10.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("Banana","Apple","Melon","Grape","Strawberry"));
		System.out.println(list);
		
		// list.stream() �ϸ� ���� ����ִ� �ֵ��� �� ���´�.. �׷��� ���Ҹ� �빮�ڷ� �ٲٴ� �����۾��� �Ұǵ� �װ��� object �迭�� �ٲٰڴ�.
		Object [] pro1 = list.stream().map(e->e.toUpperCase()).toArray();  // �� ���ҿ� �� �����ϰڴ�.
		System.out.println(Arrays.toString(pro1));  // �迭�� ������� �� �ִ� ���̴�.
		System.out.println(list); // ������ �ٲ��� �ʾҴ�.
		
		
		// ������ ���Ǽ� �ش�ȭ�ϱ� ���ؼ� ����� ���̴�. ���������� �������� ���ٰ� �ϽŴ�.
		list.stream().map(String::toUpperCase).forEach(System.out::println); // ������ �ٿ������� �ϴ� ���̴�.
		// ���ٽ��� �� ���̱� ������ :: ǥ�����̴�.
	}

}
