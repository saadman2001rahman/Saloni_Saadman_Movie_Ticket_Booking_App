package application;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class BookingSystem {
	
	
	public double calculateTotalPrice(double basePrice, Theater theater, Schedule date, Seat seatNum) {
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
        else if (date.getTime().isAfter(LocalTime.of(18,0))){
            totalAmount += 0.2 * totalAmount;
        }

        if(seatNum.getType() == "recliner"){
            totalAmount += 0.2 * totalAmount;
        }
        //https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(totalAmount));

       
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
