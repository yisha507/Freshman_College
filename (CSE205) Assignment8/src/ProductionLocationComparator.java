// Assignment #: 8
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: 10:45 MWF
//  Description: Class that compares based on production location

import java.util.*;

public class ProductionLocationComparator implements Comparator<Movie> {
	
	//returns true if the location match
	public int compare(Movie first, Movie second) {
		int result = 0;

		if(first.getProdCompany().getLocationState() == second.getProdCompany().getLocationState()) {
			
			result = first.getProdCompany().getLocationCity().compareTo(second.getProdCompany().getLocationCity());
		
		}
		else 
			result = first.getProdCompany().getLocationState().compareTo(second.getProdCompany().getLocationState());
		
		return result;
	}
}
