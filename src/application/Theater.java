package application;

import java.util.ArrayList;

public class Theater {
	private int theaterNum;
	private String type = "normal"; //normal, 3D, Dolby
	private ArrayList<Schedule> scheduleArrayList;
	
	public Theater(int theaterNum, String type) {
		this.theaterNum = theaterNum;
		this.type = type;
	}
	
	public int getTheaterNum() {
		return this.theaterNum;
	}
	
	public void setScheduleArrayList(ArrayList<Schedule> scheduleArrayList) {
		this.scheduleArrayList = scheduleArrayList;
	}
	
	public ArrayList<Schedule> getScheduleArrayList(){
		return this.scheduleArrayList;
	}
	
    public Boolean checkBooking(Schedule date, Seat seatNumber){
        return date.checkBooking(seatNumber);
    }

    public void bookSeat(Schedule date, Seat seatNumber){
        date.bookSeat(seatNumber);
    }
    
	public String getType() {
		return type;
	}



}
