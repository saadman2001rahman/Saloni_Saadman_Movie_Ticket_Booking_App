package application;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;

public class Schedule {
	private Year year;
	private Month month;
	private DayOfWeek day;
	
	private LocalTime[] time= {LocalTime.of(8, 45), LocalTime.of(10, 15), LocalTime.of(12, 15), LocalTime.of(14, 30), LocalTime.of(16, 10), LocalTime.of(19, 15), LocalTime.of(21, 30)};
	
	public Schedule(Year year, Month month, DayOfWeek day) {
		
	}
}
