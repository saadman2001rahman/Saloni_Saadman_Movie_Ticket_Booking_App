package application;

	
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalTime;

//	public String getUsername() {
//		return username;
//	}
	
// 	public void addMovie(Movie amovie) throws IOException {
// 		String specialChar = "%%%";
// 	    String movie_representaion = amovie.getMovieName() + specialChar + amovie.getTheatreName() + specialChar + amovie.getRating() + specialChar + amovie.getLen() + specialChar + amovie.getbasePrice() + specialChar + amovie.getGenres();
// 		BufferedWriter writer = new BufferedWriter(new FileWriter("ListOfMovies.txt", true));
// 		writer.write(movie_representaion);
// 		writer.close();
// 	}

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Admin extends User{
	public Admin(String uID, String uName, int uAge) {
		super(uID, uName, uAge);
	}
	
//	public void addMovie(Movie movieToAdd, Theater theaterNum, ArrayList<Schedule>availDates) {
//		theaterNum.setScheduleArrayList(availDates);
//		movieToAdd.addTheater(theaterNum);
//	}
//	public void linkMovie(Movie movieToAdd, Theater theaterNum, ArrayList<Schedule>availDates) {
//		theaterNum.setScheduleArrayList(availDates);
//		movieToAdd.addTheatre(theaterNum);
//	}
	
 	public void addMovieToFile(Movie amovie) throws IOException {
		String specialChar = "%%%";
	    String movie_representaion = amovie.getMovieName() + specialChar + "In theater: " + specialChar + amovie.getTheatreNumber() + specialChar + amovie.getTheaterType() + specialChar + amovie.getLen() + specialChar + amovie.getbasePrice() + specialChar + amovie.getGenres();
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/application/ListOfMovies.txt", true));
		writer.write(movie_representaion + "\n");
		writer.close();
	}

	
//	private static ArrayList<Seat> setAllSeats(){
//		ArrayList<Seat>availSeats = new ArrayList<>();
//		char[] rowArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
//		int[] columnArr = {1,2,3,4,5,6,7,8,9,10,11};
//		for (char row : rowArr) {
//			for( int column : columnArr) {
//				if(row == 'E' && column >= 4 && column <=8) {
//					availSeats.add(new Seat(row, column, "wheelchair"));
//				}
//				else if(row =='D' || row == 'C') {
//					availSeats.add(new Seat(row, column, "recliner"));
//				}
//				else {
//					availSeats.add(new Seat(row, column, "normal"));
//				}
//			}
//		}
//		return availSeats;
//	}
	
	//https://www.baeldung.com/java-between-dates
    private static Calendar getCalendarWithoutTime(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
    
    public static ArrayList<Date> getDatesBetween(Date startDate, Date endDate){
    	ArrayList<Date> datesInRange = new ArrayList<>();
    	Calendar calendar = getCalendarWithoutTime(startDate);
    	Calendar endCalendar = getCalendarWithoutTime(endDate);
    	
    	while (calendar.before(endCalendar)) {
    		Date result = calendar.getTime();
    		datesInRange.add(result);
    		calendar.add(Calendar.DATE, 1);
    	}
    	return datesInRange;
    }
	
    
//    public ArrayList<Schedule> createScheduleList(Date startDate, Date endDate, LocalTime[] localTimes){
//    	ArrayList<Date> dates = getDatesBetween(startDate, endDate);
//    	ArrayList<Seat> availSeats = setAllSeats();
//    	ArrayList<Schedule> createdScheduleList = new ArrayList<>();
//    	
//    	for (Date date : dates) {
//    		for(LocalTime selectedTime: localTimes) {
//    			createdScheduleList.add(new Schedule((Date) date.clone(), selectedTime, availSeats));
//    		}
//    	}
//    	
//    	return createdScheduleList;
//    }

}
