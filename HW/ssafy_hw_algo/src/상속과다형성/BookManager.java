package 상속과다형성;



public class BookManager{
	private final static int MAX_SIZE=100;
	private Book[] books=new Book[MAX_SIZE];
	private int size;//등록된 책의 개수
	
	public void add(Book book) {
		if(size < MAX_SIZE) {//MAX_SIZE보다 작을 때만 등록 가능
			books[size++]=book;
		}else {
			System.out.println("등록 불가");
		}
		//System.out.println("추가 후:"+Arrays.toString(books));
	}
	public void remove(String isbn) {  // isbn이 책의 유일성을 검사해준다.
		Book[] imsi=new Book[MAX_SIZE];
		int j=0;
		for(int i=0;i<size;i++,j++) {
			if(books[i].getIsbn().equals(isbn)) {//현재 책이 삭제 대상이면		
				--j;  // 원래 j 에서 하나 빼버리면 하나가 안쪽으로 줄어든 값을 가지게 된다.
				continue;//임시 배열에 넣지 않고 계속 진행
			}
			imsi[j]=books[i];
		}
		books=imsi;
		size=j+1; // 저 j는 안에 인덱스가 몇 개 있나 보기 위함인데 0부터 시작헀으니 1 더해주는 것이다.
		//System.out.println("삭제 후:"+Arrays.toString(books));
	}
	public Book[] getList() {   // 우리 집 금송아지를 가져가는 ....
		Book dest[]=new Book[size];  // 그냥 리턴 북 하면 안된다. 그래서 이걸 가져가게 하면 내가 갖고있는 데이터의 복사본을 줘야 한다...
		System.arraycopy(books, 0, dest, 0, size);   // 원본을 바꾸고 싶다면 내 set 메서드를 사용해라.
		return dest;//보안 상 복사본 리턴

	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<size;i++) {			
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
	public Book[] searchByTitle(String title) {
		Book[] imsi=new Book[size];
		int imsi_size=0;
		for(int i=0;i<size;i++) {			
			if(books[i].getTitle().contains(title)) {
				imsi[imsi_size++]=books[i];  // 이렇게 카피해서 
			}
		}
		if(imsi_size>0) {
			Book[] searchedBooks=new Book[imsi_size];  // 카피한거 바로 갖다 쓴거 아니고 이렇게 new 해서 준 이유는 뭐냐?
			for (int i = 0; i < imsi_size; i++) {  // 요 사이즈는 원본에 들어있었던 것중 찾은 2개만 딱 갖다 쓰기 위해서 - 배려하는 코드이다.
				searchedBooks[i]=imsi[i];
			}   // 이건 c스타일 코드인데 이게 더 빠르다. 위에 arraycopy 와 기능은 같은데 속도는 더 빠르다. 속도는 빠른데 나쁜 자세이다..... 열심히....
			return searchedBooks;      // 균형을 잃지 않도록... 자바는 객체 지향 언어이다. 의식적으로 해야한다!!!
		}
		return null;
	}
	public Magazine[] getMagazines() {
		Magazine[] imsi_magazines=new Magazine[size];
		int real_magazines_size=0;
		for(int i=0;i<size;i++) {			
			if(books[i] instanceof Magazine) {
				imsi_magazines[real_magazines_size++]=(Magazine)books[i];
			}
		}
		if(real_magazines_size>0) {
			Magazine[] real_magazines=new Magazine[real_magazines_size];
			for(int i=0;i<real_magazines_size;i++) {
				real_magazines[i]=imsi_magazines[i];
			}
			return real_magazines;
		}
		return null;
	}
	public Book[] getBooks() {
		Book[] imsi=new Book[size];
		int only_books_size=0;
		for(int i=0;i<size;i++) {			
			if(books[i] instanceof Magazine) {
				
				--only_books_size;
				continue;				
			}
			imsi[only_books_size++]=books[i];
		}
		//System.out.println(only_books_size);
		if(only_books_size>0) {
			Book[] only_books=new Book[++only_books_size];
			for(int i=0;i<only_books_size;i++) {
				only_books[i]=imsi[i];
			}
			return only_books;
		}
		return null;
	}
	public int getTotalPrice() {
		int totalPrice=0;
		for (int i = 0; i < size; i++) {
			totalPrice += books[i].getPrice();
		}
		return totalPrice;
	}
	public double getPriceAvg() {
		return getTotalPrice()/size;
	}
}
