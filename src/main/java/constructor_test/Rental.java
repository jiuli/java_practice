package constructor_test;

import lombok.Data;

@Data
public class Rental{
	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie, int daysRented){
		this.movie = movie;
		this.daysRented = daysRented;
	}


}