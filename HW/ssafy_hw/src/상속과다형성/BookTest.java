package 상속과다형성;

public class BookTest {

	public static void main(String[] args) {
		Book b1=new Book("21424", "Java Pro", "김하나", "jaen.kr", "Java 기본 문법", 15000);		
		Book b2=new Book("21425", "Java Pro2", "김하나", "jaen.kr", "Java 응용", 25000);
		Book b3=new Book("35355", "분석설계", "소나무", "jaen.kr", "SW 모델링", 30000);
		Magazine b4=new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", "1월 알고리즘", 10000, 2021, 1);
		
		BookManager bm=new BookManager();
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(b4);
		
//		Book []all =bm.getList();
//		all[0] = null; 바로 아랫줄과 동일한 코드이다.
//		bm.getList()[0] = null;
		Book book = bm.searchByIsbn("21424");
		if (book != null) {
			book.setTitle("재미없는 만화책");
			System.out.println(book.getTitle());
		}
		
		System.out.println("****************도서 전체 목록******************");
		Book[] all_books=bm.getList();
		for (int i = 0; i < all_books.length; i++) {
			System.out.println(all_books[i]);
		}
		
		System.out.println("****************일반 도서 목록******************");
		Book[] only_books=bm.getBooks();
		if(only_books!=null) {
			for (int i = 0; i < only_books.length; i++) {
				System.out.println(only_books[i]);
			}
		}
		
		System.out.println("****************잡지 목록******************");
		Magazine[] real_magazines=bm.getMagazines();
		if(real_magazines!=null) {
			for (int i = 0; i < real_magazines.length; i++) {
				System.out.println(real_magazines[i]);
			}
		}
		
		System.out.println("****************도서 제목 포함 검색******************");
		Book[] searchedBooks=bm.searchByTitle("Java");
		if(searchedBooks!=null) {
			for (int i = 0; i < searchedBooks.length; i++) {
				System.out.println(searchedBooks[i]);
			}
		}
		
		System.out.println("도서 가격 총합 : "+bm.getTotalPrice());
		System.out.println("도서 가격 평균: "+bm.getPriceAvg());
	}

}
