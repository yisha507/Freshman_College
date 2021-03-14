// Assignment #: 5
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM
//  Description: utility class that will be used to create an 
//  object of a child class of Employee class from a parsable string

public class EmployeeParser {
	
	public static Employee parseStringToEmployee(String lineToParse) {
		
		//Employee object to hold child classes
		Employee employee = null;  
		
		//string array to hold StringToMember argument
		String []employeeInfo = new String[6];  
		
		employeeInfo = lineToParse.split(":"); 
		
		if(employeeInfo[0].equalsIgnoreCase("fulltime")) 
			employee = new FullTimeEmployee(employeeInfo[1], employeeInfo[2], employeeInfo[3], 
					
					//creates and adds fullTimeEmployee object to Employee object 
					Double.parseDouble(employeeInfo[4]), Double.parseDouble(employeeInfo[5])); 
		
		if(employeeInfo[0].equalsIgnoreCase("parttime")) 
			employee = new PartTimeEmployee(employeeInfo[1], employeeInfo[2], employeeInfo[3], 
					
					//creates and adds PartTimeEmployee object to Employee object			   
					Double.parseDouble(employeeInfo[4]), Integer.parseInt(employeeInfo[5]));  
		
		return employee; 
		
		
	}
}
