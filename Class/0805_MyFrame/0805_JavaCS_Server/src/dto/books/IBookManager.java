package dto.books;

import java.util.List;

public interface IBookManager {
	public void add(Book book);
	public void remove(String isbn);
	public List<Book> getBooks();
	public Book searchByIsbn(String isbn);
	public List<Book> searchByTitle(String title);
	public List<Magazine> getMagazines();
	public int getTotalPrice();
	public double getPriceAvg();
}
