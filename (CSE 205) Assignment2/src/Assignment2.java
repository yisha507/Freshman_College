// Assignment #: 2
// Arizona State University - CSE205
//         Name: Yisha Fan 
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM 
//  Description: a program that reads in an unspecified number of 
//  integers from standard input, performs some calculations 
//  on the inputted numbers, and outputs the 
//  results of those calculations to standard output.

import java.util.Scanner;

public class Assignment2 {
	
	public static void main(String[] args) {
		
		//Declares and instances variables
		int minInt = Integer.MAX_VALUE;
		int smallestEven= 0;
		int negCount = 0;
		int sumOdd = 0;
		int nextInt;
		int nextEven;
		
		
		//creates scanner object
		Scanner in = new Scanner(System.in);
		
		
		
		//do while loop that accepts int and checks entered number
		do {
			//sets nextInt to user input integer
			nextInt = in.nextInt();
			
			
			//if the next integer is smaller or equal  to maxVal; set smallest number to that integer
			if(nextInt < minInt) {
				minInt = nextInt;
				
			}
				
			//counts amount of negative numbers
			if(nextInt < 0)
				negCount++;
			
			//checks smallest even integer
			if(nextInt % 2 == 0){
				nextEven = nextInt;
				
				if(nextEven < smallestEven) {
				smallestEven = nextEven;
				}
			}
			
			//adds together all odd integers
			if(nextInt % 2 != 0)
				sumOdd += nextInt;
		
		}while(nextInt != 0); 
		
		
		//displays output
		System.out.println("The minimum integer is " + minInt +
						   "\nThe smallest even integer in the sequence is " + smallestEven +
						   "\nThe count of negative integers in the sequence is " + negCount +
						   "\nThe sum of odd integers " + sumOdd);
	}
}
