package application;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class BookingSystem {
	
	
//	public double calculateTotalPrice(double basePrice, Theater theater, Schedule date, Seat seatNum) {
//        double totalAmount = basePrice;
//        if(theater.getType() == "3D"){
//            totalAmount += 0.1 * totalAmount;
//        }
//        else if (theater.getType() == "Dolby") {
//            totalAmount += 0.2 * totalAmount;
//        }
//
//        if(date.getTime().isAfter(LocalTime.of(12,0))){
//            totalAmount += 0.1 * totalAmount;
//        }
//        else if (date.getTime().isAfter(LocalTime.of(18,0))){
//            totalAmount += 0.2 * totalAmount;
//        }
//
//        if(seatNum.getType() == "recliner"){
//            totalAmount += 0.2 * totalAmount;
//        }
//        //https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
//        DecimalFormat df = new DecimalFormat("0.00");
//        return Double.parseDouble(df.format(totalAmount));
//
//       
//    }

	
//	public void bookMovieTicket(Customer customer, Movie movie,Theater theater, Schedule date, Seat seatNumber){
//		if(checkBooking(theater, date, seatNumber)) {
//			double totalPrice = calculateTotalPrice(movie.getbasePrice(), theater, date, date.getSeat(seatNumber));
//			if(customer.hasEnoughBalance(totalPrice)) {
//				customer.setAmountBalance(totalPrice);
//				theater.bookSeat(date, seatNumber);
//				System.out.println(customer.getName() +" has booked " + seatNumber.getSeat() + " for the movie " + movie.getMovieName() + "playing in theater number " +theater.getTheaterNum() +" at "+ date.getString());
//				System.out.println(customer.getName() + " has paid $" + totalPrice);
//			}
//		}
//		else {
//			System.out.println(seatNumber.getSeat() + " for the movie " + movie.getMovieName() + " playing in theatre number " + theater.getTheaterNum() + " at " + date.getString()+ " is already booked!");
//		}
//	}
	public Boolean checkBooking(Theater theater, Schedule date, Seat seatNum) {
		return theater.checkBooking(date, seatNum);
	}

}
