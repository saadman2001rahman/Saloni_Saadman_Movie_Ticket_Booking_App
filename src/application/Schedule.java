package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Schedule {
	private Date scheduledDate;
	private LocalTime hourMin;
	private ArrayList<Seat> availableSeats;
	//for local time: https://www.joda.org/joda-time/apidocs/org/joda/time/LocalTime.html
	
	/**
	 * Construct a schedule with a selected time for a movie play-time and assigns a list of seats to it
	 * @param date
	 * @param hourMin
	 * @param availableSeats
	 */
	public Schedule(Date date, LocalTime hourMin, ArrayList<Seat> availableSeats) {
		this.scheduledDate =date;
		this.hourMin =hourMin;
		this.scheduledDate.setHours(hourMin.getHour());
		this.scheduledDate.setMinutes(hourMin.getMinute());
		this.availableSeats = availableSeats;
	}
	
	/**
	 * Check if a selected seat for a particular date is booked
	 * @param selectedSeat
	 * @return
	 */
	public Boolean checkBooking(Seat selectedSeat) {
		for(Seat availSeat : this.availableSeats) {
			if(availSeat.checkEqual(selectedSeat)) {
				return true; //seat is available
			}
		}
		return false; //seat is booked
	}
	
	/**
	 * Book seat by removing it from list of available seats
	 * @param selectedSeat
	 */
	public void bookSeat(Seat selectedSeat) {
		for(Seat seat : this.availableSeats) {
			if(seat.checkEqual(selectedSeat)) {
				this.availableSeats.remove(seat);
				break;
			}
		}
	}
	
	/**
	 * Get seat from the schedule
	 * @param selectedSeat
	 * @return
	 */
	public Seat getSeat(Seat selectedSeat) {
		for(Seat seat: this.availableSeats) {
			if(seat.checkEqual(selectedSeat)) {
				return seat;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return scheduleDate as a string
	 */
	public String getString() {
		return this.scheduledDate.toString();
	}
	
	public LocalTime getTime() {
		return this.hourMin;
	}
	
	public ArrayList<Seat> getAvailableSeats(){
		return this.availableSeats;
	}

}
