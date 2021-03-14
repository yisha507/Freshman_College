// Assignment #: 9
// Arizona State University - CSE205
//         Name: Yisha Fan 
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM 
//  Description: program that reads in a sequence of integers from standard input until 0 is read, and store them in an array (including 0)

import java.io.*;
public class Assignment9 {
	 //method to find the smallest number in the array
	
	public static void main(String[] args) {
		BufferedReader br = null;
		InputStreamReader in = null;
		String userInput ="1";
		int i = 0;
		int[] intArray = new int[100];
		
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			//while the user does not input 0
			while(Integer.parseInt(userInput) != 0) {
				//reads in next line of user input
				userInput = br.readLine();
				
				//breaks loop if user enters 0
				if(Integer.parseInt(userInput) == 0)
					break;
				
				//adds user input integer into array
				intArray[i] = Integer.parseInt(userInput);
				
				//iterates index of array
				i++;
			}
			}
		
		catch(IOException ex) {
			System.out.println(ex);	
		}
		
		//Prints min number
		System.out.println("The minimum number is " + findMin(intArray, 0, i-1));
		
		//prints min even integer
		System.out.println("The smallest even integer in the sequence is " + computeSmallestEven(intArray, 0, i-1));
		
		//prints number of neg integers
		System.out.println("The count of negative integers in the sequence is " + countNegativeNumbers(intArray, 0, i-1));
		
		//prints sum of num divisible by 3
		System.out.println("The sum of numbers that are divisible by 3 is " + computeSumOfNumbersDivisibleBy3(intArray, 0, i-1));
	
	}
	
	//finds smallest number in array
	 public static int findMin(int[] elements, int startIndex, int endIndex) { 
		
		 	//once last index reached, return value left
		 	if(startIndex == endIndex) {
		 		return elements[startIndex];
		 	}
		 	//calls on the method using recursion
		 	int min = findMin(elements, startIndex+1, endIndex);
		 	
		 	if(min > elements[startIndex]) {
		 		return elements[startIndex];
		 	}
		 	else {
		 	return min;
		 	}
		 	
		 	
		 		
	 }
	 	
	 //method to find the smallest even number in the array
	 public static int computeSmallestEven(int[] elements, int startIndex, int endIndex) {
		
		 //once last index reached, return value left
		 if(startIndex == endIndex) {
		 		return 0;
		 	}
		
		 	//calls on the method using recursion
		 	int min = computeSmallestEven(elements, startIndex+1, endIndex);
		 
		 	//determines if num at index is smallest and even
		 	if(min > elements[startIndex] && elements[startIndex] % 2 == 0) {
		 		return elements[startIndex];
		 	}
		 	else {
		 	return min;
		 	}
	 }
	    
	 //method to find the number of negative number in the array
	 public static int countNegativeNumbers(int[] elements, int startIndex, int endIndex) {
		
		 //once last index reached, check if num is neg
		 if(startIndex == endIndex) {
			 
			 if(elements[startIndex] >= 0)
				 return 0;
			 else
				 return 1;
		 }
		 else {
			 //calls on the method using recursion
			 int count = countNegativeNumbers(elements, startIndex+1, endIndex);
		 
		 	if(elements[startIndex] < 0) {
		 		return count+1;
		 	}
		 	else
		 		return count;
		 }
	 }
	    
	 //method to find the sum of the numbers divisible by three in the array
	 public static int computeSumOfNumbersDivisibleBy3(int[] elements, int startIndex, int endIndex) {
		
		 //once last index reached, check if num divisible by 3
			if (endIndex == startIndex)
			{
				if (elements[endIndex] % 3 == 0)
				{
					int sum = elements[endIndex];
					return sum;
				}
				else
				{
					int sum = 0;
					return sum;
				}
			}
			else
			{
				//calls on the method usingg recursion
				int sum = computeSumOfNumbersDivisibleBy3(elements, startIndex+1, endIndex);
				
				//add num at index to the sum if divisible by 3 
				if (elements[startIndex] % 3 == 0)
				{
					return sum += elements[startIndex];
				}
				else
				{
					return sum;
				}
			}
	    
	 }
	
}
