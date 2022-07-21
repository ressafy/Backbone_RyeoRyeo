package 상속과다형성;

public class Book {
	private String isbn,title,author,publisher,desc;
	private int price;
	public Book() {
		super();
	}
	public Book(String isbn, String title, String author, String publisher, String desc, int price) {
		super();
		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setPrice(price);
		setPublisher(publisher);
		setDesc(desc);
	}
	
	@Override
	public String toString() {
		return isbn + "\t| " + title + "\t\t| "+ author+"\t| "+publisher+"\t\t| "+price+" | "+desc;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		if(isbn != null)  // 유효성 검사 코드
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(isbn.startsWith("2") && title.startsWith("Java")) {
			this.title = title;
		}else if(isbn.startsWith("3") && title.startsWith("분석")){
			this.title = title;
		}else if (isbn.startsWith("4") && title.startsWith("월간")) {
			this.title = title;
		}else {
			System.out.println("카테고리에 없는 제목입니다.");
		}
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
