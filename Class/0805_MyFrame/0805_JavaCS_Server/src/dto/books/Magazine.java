package dto.books;

public class Magazine extends Book{
	private int year, month;

	public Magazine() {
		super();
	}

	public Magazine(String isbn, String title, String author, String publisher, String desc, int price,
			int year, int month) {
		super(isbn, title, author, publisher, desc, price);
		
		setYear(year);
		setMonth(month);
		
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		if(year>0)
		this.year = year;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		if(month>0 && month<13)
		this.month = month;
	}


	@Override
	public String toString() {
		return "Magazine [isbn=" + super.getIsbn() + ", title=" + super.getTitle() + ", author=" + super.getAuthor()
				+ ", publisher=" + super.getPublisher() + ", desc=" + super.getDesc()
				+ ", price=" + super.getPrice()
				+", year=" + this.year + ", month" + this.month + "]";
	}
}
