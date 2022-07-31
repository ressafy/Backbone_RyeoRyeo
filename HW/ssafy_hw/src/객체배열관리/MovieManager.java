package 객체배열관리;

public class MovieManager {
	private final int MAX_SIZE = 100;
	private Movie[] movie_list = new Movie[MAX_SIZE];
	private int size = 0;
	
	public void add(Movie m) {
		if(size < MAX_SIZE) {
			movie_list[size++] = m;
		}else {
			System.out.println("You entered more than 100");
		}
	}
	
	public Movie[] getList() {
		Movie[] result_list = new Movie[size];
		for(int i = 0; i<this.size;i++) {
			if (movie_list[i] != null) {
				result_list[i] = movie_list[i];
			}
		}
		return result_list;
	}
	
	public Movie[] searchByTitle(String movieTitle) {
		int cnt = 0;
		for(int i = 0; i<this.size;i++) {
			if(movie_list[i].getTitle().contains(movieTitle)) {
				cnt ++;
			}
		}
		int idx = 0;
		Movie[] result_list = new Movie[cnt];
		for(int j = 0; j< this.size;j++) {
			if(movie_list[j].getTitle().contains(movieTitle)) {
				result_list[idx++] = movie_list[j];
			}
		}
		return result_list;
	
}
	}
