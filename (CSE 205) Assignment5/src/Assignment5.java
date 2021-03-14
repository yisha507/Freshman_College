// Assignment #: 5
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM
//  Description: The Assignment 5 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5
 {
  public static void main (String[] args)
   {
     // ArrayList object is used to store Employee objects
     ArrayList employeeList = new ArrayList();

     try
      {
       printMenu();     // print out menu

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);
          
       String line, inputInfo;
       boolean operation = false;
       char input1;
       do
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           switch (input1)
            {
             case 'A':   //Add Employee
               System.out.print("Please enter some employee information to add:\n");
               inputInfo = stdin.readLine().trim();
                    
               /***********************************************************************************
               ***  ADD your code here to call employee parser method to parse the string, 
               ***  then add the returned object to the list of employee
               ***********************************************************************************/
               
               //creates employee object and passes string from inputInfo into EmployeeParser class
               Employee employee = EmployeeParser.parseStringToEmployee(inputInfo); 
               
               //adds object from employee to employeeList array
               employeeList.add(employee);											     
               
               break;
                    
             case 'C':   //Compute Pay Amount
                    
               /***********************************************************************************
               ***  ADD your code here to compute pay amounts for all employees
               ***********************************************************************************/
            	
            	 //computes pay for different objects that are held in employeeList
            	 for(int i=0; i<employeeList.size(); i++)							
                 {
    				 ((Employee) employeeList.get(i)).computePayAmount();
    			 }
            	 
                System.out.print("pay amount computed\n");
               break;
             case 'D':   //Search for Employee
               System.out.print("Please enter an employeeID to search:\n");
               String id = stdin.readLine().trim();

                /***********************************************************************************
                ***  ADD your code here to search an employee with the entered id
                ***********************************************************************************/
               
               //reads string input from user and compares it to each employee id
               for(int i=0; i<employeeList.size(); i++)						
               {   
            	   //checks if selected employee id is equal to one entered by user
            	   if(((Employee) employeeList.get(i)).getEmployeeId().equalsIgnoreCase(id))
            		   operation = true;
            	   
            	   if (operation == true) {
            		   System.out.print("Employee found\n");
                       break;
            	   }
            	   else {
                       System.out.print("Employee not found\n");
                       break;
                       }
               }
               break;
             case 'L':   //List Employees
                    
                /***********************************************************************************
                ***  ADD your code here to print all employee, print "no employee\n" if the list is empty
                ***********************************************************************************/
            	//prints all details about employee objects
            	 if(employeeList.size() > 0) {
            		 for(int i=0; i<employeeList.size(); i++)							
            		 {
            			 System.out.print(employeeList.get(i));
            		 }
            	 }
            	 else
            		 System.out.println("no employee\n");
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q'); // stop the loop when Q is read
      }
     catch (IOException exception)
      {
        System.out.println("IO Exception");
      }
  }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Employee\n" +
                      "C\t\tCompute Pay\n" +
                      "D\t\tSearch for Employee\n" +
                      "L\t\tList Employees\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}


