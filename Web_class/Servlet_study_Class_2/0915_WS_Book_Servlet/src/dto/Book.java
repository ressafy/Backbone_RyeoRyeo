package dto;

public class Book {
	
	private String isbn,title,author, desc;
	private int price;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	
	public Book(String isbn, String title, String author, String desc, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.desc = desc;
		this.price = price;
	}
	public Book() {
		super();
		
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", desc=" + desc + ", price=" + price
				+ "]";
	}
	
	
}
