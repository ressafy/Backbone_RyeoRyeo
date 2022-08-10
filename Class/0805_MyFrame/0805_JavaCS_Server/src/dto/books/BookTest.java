package dto.books;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("21424", "py Pro", "김하나", "jaen.kr", "Java 기본문법", 15000);
		Book b2 = new Book("35355", "Java Pro", "소나무", "jaen.kr", "sw 모델링", 30000);
		Book b3 = new Book("12345", "Java Pro", "김히비", "jaen.kr", "머신러닝", 50000);
		Magazine m1 = new Magazine("33333", "Java Pro", "김랄로", "jaen.kr", "딥러닝", 60000, 2013, 7);
		Magazine m2 = new Magazine("44444", "py Pro", "송아지", "jaen.kr", "러닝", 70000, 2017, 5);

		BookManagerImpl bm = new BookManagerImpl();
		System.out.println("======== add test =========");
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);

		for (Book b :
				bm.getBooks()) {
			System.out.println("b = " + b.toString());
		}
		System.out.println("==============================");

		bm.remove("21424");
		bm.remove("35355");

		System.out.println("======== remove test =========");
		for (Book b :
				bm.getBooks()) {
			System.out.println("b = " + b.toString());
		}
		System.out.println("==============================");

		bm.add(b1);
		bm.add(b2);

		bm.add(m1);
		bm.add(m2);

		System.out.println("======== searchByIsbn test =========");
		System.out.println(bm.searchByIsbn("21424").toString());
		System.out.println("==============================");

		System.out.println("======== searchByTitle test =========");
		for (Book b :
				bm.searchByTitle("Java Pro")) {
			System.out.println("Java Pro list=> " + b.toString());
		}
		System.out.println("==============================");


		System.out.println("======== getMagazines test =========");
		for (Magazine m :
				bm.getMagazines()) {
			System.out.println("m = " + m.toString());
		}
		System.out.println("==============================");


		System.out.println("======== getBooks test =========");
		for (Book b :
				bm.getBooks()) {
			System.out.println("book = " + b.toString());
		}
		System.out.println("==============================");


		System.out.println("======== getTotalPrice test =========");
		int totalPrice = bm.getTotalPrice();
		System.out.println("totalPrice = " + totalPrice);
		System.out.println("==============================");

		System.out.println("======== getPriceAvg test =========");
		double avgPrice = bm.getPriceAvg();
		System.out.println("avgPrice = " + avgPrice);
		System.out.println("==============================");

	}

}
