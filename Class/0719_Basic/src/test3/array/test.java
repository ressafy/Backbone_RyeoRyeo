package test3.array;

public class test {

	public static void main(String[] args) {
		int [] all = new int[5];
		System.out.println(all);
		System.out.println(all[0]);
		all[0] = 1;
		System.out.println(all[0]);
		System.out.println(all.length);
		
		String []all2 = new String[5];
		System.out.println(all2);
		System.out.println(all2[0]);
		all2[0]=new String("java");
		all2[1]=new String("java");
		all2[2]="java";
		all2[3]="java";
		
		for(int i = 0; i<all2.length;i++) {
			System.out.println(all2[i]);
		}
	}

}

