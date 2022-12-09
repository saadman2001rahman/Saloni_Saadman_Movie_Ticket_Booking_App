package application;

public class Seat {
	private char row;
	private int column;
//	private String type;
	
	/**
	 * Construct a seat with a row of type char and column of type int (e.g A1, A2, ...)
	 * @param row
	 * @param column
	 */
	public Seat(char row, int column) {
		this.row = row;
		this.column = column;
	}
	
//	public Seat(char row, int column, String type) {
//		this.row = row;
//		this.column = column;
//		this.type = type;
//	}
	
//	public void setType(String type) {
//		this.type = type;
//	}
//	
//	public String getType() {
//		return this.type;
//	}
	
	public String getSeat() {
		return "Seat: " + row + column;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public char getRow() {
		return this.row;
	}
	
	public Boolean checkEqual(Seat selectedSeat) {
		if( selectedSeat.getRow() == this.row && selectedSeat.getColumn() == this.column) {
			return true;
		}
		return false;
	}
}
