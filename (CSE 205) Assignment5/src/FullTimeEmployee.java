// Assignment #: 5
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM
//  Description: Subclass of Employee for Full Time Employees

import java.text.NumberFormat;

public class FullTimeEmployee extends Employee {
	
	//declares private variables
	private double salary;
	private double bonus;
	
	//creates object to format money
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	//constructor that receives variables to parent class
	public FullTimeEmployee(String firstname, String lastname, String id, double salary, double bonus) {	
		super(firstname, lastname, id);
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public void computePayAmount() {
		payAmount = salary + bonus;
	}
	
	//returns string to display output
	public String toString() {
		String output = "\nFull Time Employee:"
				+super.toString()
				+"Salary:\t\t\t" + money.format(salary)
				+"\nBonus:\t\t\t" + money.format(bonus) + "\n\n"; 
		return output;
	}
}
