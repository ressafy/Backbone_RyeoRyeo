package 클래스와객체;

public class Book{
		String isbn,title,author,publisher,desc;
		int price;
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
			return isbn+"\t| "+title+"\t| "+author+" | "+publisher+"\t\t| "+price+" | "+desc;
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
			this.title = title;
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
