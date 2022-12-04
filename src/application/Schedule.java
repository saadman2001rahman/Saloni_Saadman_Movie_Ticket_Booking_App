package application;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Schedule {
	private Date scheduledDate;
	private LocalTime hourMin;
	private ArrayList<Seat> availableSeats;
	//for local time: https://www.joda.org/joda-time/apidocs/org/joda/time/LocalTime.html
	
	public Schedule(Date date, LocalTime hourMin) {
		this.scheduledDate =date;
		this.hourMin =hourMin;
		this.scheduledDate.setHours(hourMin.getHour());
		this.scheduledDate.setMinutes(hourMin.getMinute());
		this.availableSeats = new ArrayList<>();
		setAllSeats();	
	}
	
	public Schedule(int year, int month, int day, LocalTime hourMin) {
		new Schedule(new Date (year, month, day), hourMin);
	}

	private void setAllSeats() {
		
	}
}
