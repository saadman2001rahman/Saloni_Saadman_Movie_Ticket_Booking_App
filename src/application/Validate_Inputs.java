package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Validate_Inputs {
	int integerval;
	double doubleval;
	int maxintval;
	double maxdoubleval;
	
	Validate_Inputs() {}
	
	Validate_Inputs(int num, int maxVal) {
//		error_label = alabel;
		integerval = num;
		maxintval = maxVal;
	}

	Validate_Inputs(double anum, double maxVal) {
//		error_label = alabel;
		doubleval = anum;
		maxdoubleval = maxVal;
	}
	
	public int getIntVal() {
		return integerval;
	}
	
	public double getDoubleVal() {
		return doubleval;
	}

	
	public boolean check_if_movie_exists(String movieName) throws IOException {
		boolean exists = false;
		BufferedReader reader = new BufferedReader(new FileReader("src/application/ListOfMovies.txt"));
		String line = reader.readLine();
		while (line != null) {
			String name = line.split("%%%")[0];
			if (name.equals(movieName)) {
				exists = true;				
			}
			
			line = reader.readLine();
		}
		
		reader.close();
		return exists;
	}
	
	public boolean check_if_user_exists(String username) throws IOException {
		boolean exists = false;
		BufferedReader reader = new BufferedReader(new FileReader("src/application/ListOfMovies.txt"));
		String line = reader.readLine();
		while (line != null) {
			String name = line.split("%%%")[0];
			if (line.equals(username)) {
				exists = true;				
			}
			
			line = reader.readLine();
		}
		
		reader.close();
		return exists;
	}
	
	
	String setValueInt(String valueAsString) {

    	/**
    	 * Convert the value entered into a double value. Will verify whether the number is a real number with no other characters except digits or one decimal point. The number must also be between 0 and 100. If number is valid, returns the project grade, otherwise returns 0.0
    	 * 
    	 * @param projectinput a String that holds a value entered by the user intended to be a project grade
    	 * @return the project value entered by the user if it is a valid real number, 0 otherwise
    	 */
		
		String errorLaBel = "";
    	int decimalcount = 0;	//Counts the number of decimal points in number
    	for (char c : valueAsString.toCharArray()) {
    		if (c == '.') {	
    			decimalcount += 1;	//iterates with each decimal point in the number
    		
    		} else if (!Character.isDigit(c)) {		//check if each character is a digit
    			errorLaBel = "Do not use " + c + " in this field. Please enter a valid integer.";
    			return errorLaBel;
    		}     		
    	}
    	
    	//real numbers cannot have more than one decimal or end with a decimal point
    	if (decimalcount > 0 || valueAsString.endsWith(".")) {
    		errorLaBel = "Enter a valid integer.";
   			
		} else {
			//check to see if real number is within the limits of the grade
			integerval = Integer.parseInt(valueAsString);
	    	if (integerval < 0 || integerval > maxintval) {
	    		errorLaBel = "Invalid value. Value in field should be between 0 and " + maxintval;
	    		integerval = 0;
	    	}

    			
		}

    	return errorLaBel;		
    
	}
	
	String setValueDouble(String valueAsString) {

    	/**
    	 * Convert the value entered into a double value. Will verify whether the number is a real number with no other characters except digits or one decimal point. The number must also be between 0 and 100. If number is valid, returns the project grade, otherwise returns 0.0
    	 * 
    	 * @param projectinput a String that holds a value entered by the user intended to be a project grade
    	 * @return the project value entered by the user if it is a valid real number, 0 otherwise
    	 */
		
		String errorLaBel = "";
    	int decimalcount = 0;	//Counts the number of decimal points in number
    	for (char c : valueAsString.toCharArray()) {
    		if (c == '.') {	
    			decimalcount += 1;	//iterates with each decimal point in the number
    		
    		} else if (!Character.isDigit(c)) {		//check if each character is a digit
    			errorLaBel = "Do not use " + c + " in this field. Please enter a valid integer.";
    			return errorLaBel;
    		}     		
    	}
    	
    	//real numbers cannot have more than one decimal or end with a decimal point
    	if (decimalcount > 1 || valueAsString.endsWith(".")) {
    		errorLaBel = "Enter a valid double.";
   			
		} else {
			//check to see if real number is within the limits of the grade
			doubleval = Integer.parseInt(valueAsString);
	    	if (doubleval < 0 || doubleval > maxdoubleval) {
	    		errorLaBel = "Invalid value. Value in field should be between 0 and " + maxdoubleval;
	    		doubleval = 0;
	    	}

    			
		}

    	return errorLaBel;		
    
	}


	
	

}
