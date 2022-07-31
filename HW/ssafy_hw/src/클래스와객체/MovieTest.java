package 클래스와객체;

public class MovieTest {

	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.id = 1;
		m1.title = "ryeo's study";
		m1.director = "ryeo";
		m1.genre = "Thriller";
		m1.runningTime = 2;
		
		Movie m2 = new Movie(2,"Hwan","Ryeo world","Action",2);
		
		System.out.println("영화 id : " + m1.id);
		System.out.println("영화 제목 : " + m1.title);
		System.out.println("영화 감독 : " + m1.director);
		System.out.println("장르 : " + m1.genre);
		System.out.println("상영 시간 : " + m1.runningTime);
		System.out.println("-------------------------------");
		System.out.println("영화 id : " + m2.id);
		System.out.println("영화 제목 : " + m2.title);
		System.out.println("영화 감독 : " + m2.director);
		System.out.println("장르 : " + m2.genre);
		System.out.println("상영 시간 : " + m2.runningTime);
	}

}
