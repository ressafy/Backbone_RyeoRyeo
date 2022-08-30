package 객체배열관리;

public class MovieTest {

	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setTitle("려세계");
		m1.setDirector("려환");
		m1.setGenre("느와르");
		m1.setRunningTime(2);
		
		Movie m2 = new Movie(2,"려바라기","려환","액션",2);
		
		System.out.println("---------그냥 출력해보기");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
		MovieManager mm = new MovieManager();
		mm.add(m1);
		mm.add(m2);
		
		System.out.println("---------getList 출력");
		for(Movie a:mm.getList()) {
			System.out.println(a);
		}
		
		System.out.println("---------바가 들어간 리스트 출력");
		for(Movie a:mm.searchByTitle("바")) {
			System.out.println(a);
		}
		
		
		
		

	}

}
