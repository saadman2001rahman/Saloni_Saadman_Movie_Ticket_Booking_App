package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Schedule {
	private Date scheduledDate;
	private LocalTime hourMin;
	private ArrayList<Seat> availableSeats;
	//for local time: https://www.joda.org/joda-time/apidocs/org/joda/time/LocalTime.html
	
	public Schedule(Date date, LocalTime hourMin, ArrayList<Seat> availableSeats) {
		this.scheduledDate =date;
		this.hourMin =hourMin;
		this.scheduledDate.setHours(hourMin.getHour());
		this.scheduledDate.setMinutes(hourMin.getMinute());
		this.availableSeats = availableSeats;
	}
	public Boolean checkBooking(Seat selectedSeat) {
		for(Seat availSeat : this.availableSeats) {
			if(availSeat.checkEqual(selectedSeat)) {
				return true; //seat is available
			}
		}
		return false; //seat is booked
	}
	public Schedule(int year, int month, int day, LocalTime hourMin) {
		new Schedule(new Date (year, month, day), hourMin);
	}

	private void setAllSeats() {
		
	}
}
