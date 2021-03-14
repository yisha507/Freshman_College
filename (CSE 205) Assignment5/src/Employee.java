// Assignment #: 5
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM
//  Description: Superclass for full time and part time employees


import java.text.NumberFormat;
public abstract class Employee {
	
	//declares protected variables
	protected String firstName;
	protected String lastName;
	protected String employeeId;
	protected double payAmount;
	
	//creates object to format money
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	//constructor to set variables
	public Employee(String firstName,String lastName,String id) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = id;
		this.payAmount = 0.0;
	}
	
	//returns employee id
	public String getEmployeeId() {
		
		return employeeId;
	}
	
	//abstract method used by child classes
	public abstract void computePayAmount();
	
	//returns string to display output
	public String toString() {
		String display = "\nFirst name:\t\t"+firstName+"\n" +
                "Last name:\t\t"+lastName+"\n" +
                "Employee ID:\t\t"+employeeId+"\n" +
                "Pay Amount:\t\t"+money.format(payAmount)+"\n";
		
		return display;
	}

}
