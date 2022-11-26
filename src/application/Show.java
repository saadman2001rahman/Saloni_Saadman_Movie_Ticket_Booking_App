package application;

public class Show {

	private Schedule dates;
	private Theater cinema;
	
	public Show(Schedule date, Theater cinema) {
		this.dates = date;
		this.cinema = cinema;
	}
	
	
	public Show(Show show) {
		this.dates = show.dates;
		this.cinema = show.cinema;
		
	}
	
}
