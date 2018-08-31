package exercises;

public class Movie {
	
	public String title, studio, rating;
	
	public Movie(String title, String studio) {
		this.title = title;
		this.studio = studio;
		rating = "PG";
	}
	
	public Movie(String title, String studio, String rating) {
		this(title, studio);
		this.rating = rating;
	}
	
	public static Movie[] getPG(Movie[] movie) {
		
		Movie[] h1Array = new Movie[movie.length];
		
		for(int i = 0; i < movie.length; i++) {
			if(movie[i].rating.equals("PG")) {
				h1Array[i] = movie[i];
			}
		}
		
		for(int i = 0; i < h1Array.length; i++) {
			if(h1Array[i] == null) {
				
			} else {
				System.out.println(h1Array[i].rating);
				System.out.println(h1Array[i].studio);
				System.out.println(h1Array[i].title);
			}
			
		}
		return h1Array;
	}
}
