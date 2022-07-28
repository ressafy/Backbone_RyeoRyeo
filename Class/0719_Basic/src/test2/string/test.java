package test2.string;

public class test {

	public static void main(String[] args) {
		String s1 = new String("Java");
		String s2 = new String("Java");
		
		String s3 = "Java";
		String s4 = "Java";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		s3 = s3.concat("study");
		System.out.println(s3);
		System.out.println(s4);
		
		String s5 = "java study";
		System.out.println(s3 == s5);
		
		String s6 ="Java";
		String s7 = "java"+" study";
		System.out.println(s5 == s7);
	}

}
