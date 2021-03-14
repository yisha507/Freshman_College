// Assignment #: 5
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM
//  Description: Subclass of Employee for part time employees

import java.text.NumberFormat;

public class PartTimeEmployee extends Employee {
	
	//declares variables 
	private double hourlyRate;
	private int hours;
	
	//creates object to format money
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	//constructor that receives variables to parent class
	public PartTimeEmployee(String firstname, String lastname, String id, double hourlyRate, int hours) {
		super(firstname, lastname, id);
		this.hourlyRate = hourlyRate;
		this.hours = hours;
	}
	
	//calculates the amount an employee earned
	public void computePayAmount() {
		payAmount = hourlyRate*hours;
	}
	
	//returns string to display output
	public String toString() {
		String output = "part Time Employee:" 
				+ super.toString() +"HourlyRate:\t\t" 
				+ money.format(hourlyRate)
				+"\nHours:\t\t\t" + hours + "\n\n";;
		return output;
	}
}
