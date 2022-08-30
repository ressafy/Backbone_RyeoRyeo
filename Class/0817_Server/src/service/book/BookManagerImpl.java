package service.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dto.book.Book;
import dto.book.Magazine;

public class BookManagerImpl implements IBookManager{

	//public final static int MAX_SIZE=100;
	//private Book[] books;
	//private int size;
	private List<Book> books;
	

	public BookManagerImpl(){
		this.books = new ArrayList<>();		
	}

	public void add(Book book) {
		synchronized (books) {
			books.add(book);
		}
	}

	public void remove(String isbn) {
		synchronized (books) {
			for(Book book:books) {
				if(book.getIsbn().equals(isbn)) {
					books.remove(book);
				}
			}
		}	
	}

	@Override
	public List<Book> getBooks() {
		List<Book> dest=new ArrayList<>();;
		Collections.copy(dest, books);
		return dest;
	}

	public Book searchByIsbn(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public List<Book> searchByTitle(String title) {
		List<Book> dest=new ArrayList<>();
		for(Book book:books) {
			if(book.getTitle().contains(title)) {
				dest.add(book);
			}
		}

		return dest;
	}

	@Override
	public List<Magazine> getMagazines() {
		List<Magazine> dest=new ArrayList<>();
		for(Book book:books) {
			if(book instanceof Magazine) {				
				dest.add((Magazine)book);
			}
		}
		return dest;
	}

	

	public int getTotalPrice() {
		int totalPrice = 0;
		for(Book book:books) {
			totalPrice +=book.getPrice();
		}

		return totalPrice;
	}

	public double getPriceAvg() {
		int tP = getTotalPrice();
		double avg = (tP*1.0)/books.size();

		return avg;
	}

}