package application;
import java.time.LocalTime;
import java.util.*;

public class MainClass {
	public static void main(String[] args) throws Exception{

		 
//		Movie blackPanther = new Movie("Black Panther", new String[] {"Action", "Thriller", "Superhero"}, 161, 6);
//		Movie interstellar = new Movie("Interstellar", new String[]{"Thriller", "Fatasy", "Sci-Fi"}, 180, 7);
		
		Theater t1 = new Theater(1,"3D"); 
		Theater t2 = new Theater(2, "Dolby");
		
		ArrayList<Schedule> schedule2 = new ArrayList<>();

        Date startDate = new Date(2022 - 1900, Calendar.JANUARY, 1);
        Date endDate = new Date(2022 - 1900, Calendar.MARCH, 1);
        ArrayList<LocalTime> fixedTimes = new ArrayList<>(Arrays.asList(LocalTime.of(9,0), LocalTime.of(12,20), LocalTime.of(16,0), LocalTime.of(20,15)));
        
//        Admin employee = new Admin(4, "employee", 200);
//        ArrayList<Schedule> schedule1 = employee.createScheduleList(startDate, endDate, new LocalTime[]{fixedTimes.get(0), fixedTimes.get(2)});
//        employee.linkMovie(blackPanther, t1, schedule1);
//        employee.linkMovie(interstellar, t2, schedule2);
        
        BookingSystem bookSys = new BookingSystem();
        
        BookingSystem bookingSys = new BookingSystem();
//        bookSys.bookMovieTicket(saloni, blackPanther, t1, schedule1.get(5), new Seat('A', 1));
//        bookSys.bookMovieTicket(sadman, blackPanther, t1, schedule1.get(5), new Seat('A', 1));
//        bookSys.bookMovieTicket(amir, blackPanther, t1, schedule1.get(5), new Seat('D', 2));

	}
	
	
	

}
