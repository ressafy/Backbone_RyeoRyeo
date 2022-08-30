public class Test3 {
	public static void main(String[] args) {
		int money = 10000;
		int price = 2530;
		int change = money - price;
		int c1000 = change / 1000;
		int c500 = change % 1000 / 500;
		int c100 = change % 500 / 100;
		int c50 = change % 100 / 50;
		int c10 = change % 50 / 10;
		System.out.println("투입금액 : " + money + "원");
		System.out.println("상품금액 : " + price + "원");
		System.out.println("거스름돈 : " + change + "원");
		System.out.println("--------------");
		System.out.println("1000원 : " + c1000 + "장");
		System.out.println("500원 : " + c500 + "개");
		System.out.println("100원 : " + c100 + "개");
		System.out.println("50원 : " + c50 + "개");
		System.out.println("10원 : " + c10 + "개");
	}
}