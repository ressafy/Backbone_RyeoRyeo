package 클래스와객체;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("21424","Java Pro","김하나","jean.kr","Java 기본문법",15000);
		Book b2 = new Book("35355","분석설계\t","소나무","jean.kr","SW 모델링",30000);
		System.out.println("**********************도서목록**********************");
		System.out.println(b1.toString());
		System.out.println(b2.toString());

	}

}
