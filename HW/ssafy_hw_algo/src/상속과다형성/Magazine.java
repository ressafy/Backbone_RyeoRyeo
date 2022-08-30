package 상속과다형성;

public class Magazine extends Book{
	private int year,month;

	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(String isbn, String title, String author, String publisher, String desc, int price, int year,int month) {
		super(isbn, title, author, publisher, desc, price);
		setYear(year);
		setMonth(month);
	}

	
	@Override
	public String toString() {
		return getIsbn() + "\t| " + getTitle() + "\t\t| "+ getAuthor()+"\t| "+getPublisher()+"\t\t| "+getPrice()+" | "+getDesc()+"\t\t| "+year+"\t| "+month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year>0)
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month>0 && month <13)
		this.month = month;
	}
	
	
	
}
