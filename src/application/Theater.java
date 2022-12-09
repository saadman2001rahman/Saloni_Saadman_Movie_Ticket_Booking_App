package application;

import java.util.ArrayList;

public class Theater {
	private int theaterNum;
	private String type = "normal"; //normal, 3D, Dolby
	private ArrayList<Schedule> scheduleArrayList;
	
	/**
	 * Construct theater with a theater number and theater type
	 * @param theaterNum 
	 * @param type
	 */
	public Theater(int theaterNum, String type) {
		this.theaterNum = theaterNum;
		this.type = type;
	}

	public int getTheaterNum() {
		return this.theaterNum;
	}
	
	/**
	 * Set a schedule array list for a theater
	 * @param scheduleArrayList
	 */
	public void setScheduleArrayList(ArrayList<Schedule> scheduleArrayList) {
		this.scheduleArrayList = scheduleArrayList;
	}
	
	/**
	 * 
	 * @return The schedule array list associated with the theater
	 */
	public ArrayList<Schedule> getScheduleArrayList(){
		return this.scheduleArrayList;
	}
	
	/**
	 * Check if a seat is booked for a particular theater for a particular date
	 * @param date
	 * @param seatNumber
	 * @return
	 */
    public Boolean checkBooking(Schedule date, Seat seatNumber){
        return date.checkBooking(seatNumber);
    }

    /**
     * Book a seat at a particular theater for a particular selected schedule
     * @param date
     * @param seatNumber
     */
    public void bookSeat(Schedule date, Seat seatNumber){
        date.bookSeat(seatNumber);
    }
    
	public String getType() {
		return type;
	}


}
