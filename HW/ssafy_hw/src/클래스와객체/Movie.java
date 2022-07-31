package 클래스와객체;

public class Movie {
	int id;
	String title;
	String director;
	String genre;
	int runningTime;
	
	public Movie() {
		
	}
	
	public Movie(int id,String title,String director,String genre,int runningTime) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}
}
