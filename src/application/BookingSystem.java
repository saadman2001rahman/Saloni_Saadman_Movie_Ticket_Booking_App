package application;

import java.time.LocalTime;

public class BookingSystem {
	
	
	public void calculateTotalPrice(double basePrice, Theater theater, Schedule date, Seat seatNum) {
        double totalAmount = basePrice;
        if(theater.getType() == "3D"){
            totalAmount += 0.1 * totalAmount;
        }
        else if (theater.getType() == "Dolby") {
            totalAmount += 0.2 * totalAmount;
        }

        if(date.getTime().isAfter(LocalTime.of(12,0))){
            totalAmount += 0.1 * totalAmount;
        }
        else if (date.getTime().isAfter(LocalTime.of(6,0))){
            totalAmount += 0.2 * totalAmount;
        }

        if(seatNum.getType() == "recliner"){
            totalAmount += 0.2 * totalAmount;
        }

        return totalAmount;
    }

	
	public void bookMovieTicket(Customer custName, Theater theater, Schedule date, Seat seatNumber) throws Exception{
		if(!theater.seatBooked(date,  seatNumber)) {
			theater.bookSeat(date, seatNumber);
		}
		
		else {
			throw new Exception("Seat is booked");
		}
	}
}
