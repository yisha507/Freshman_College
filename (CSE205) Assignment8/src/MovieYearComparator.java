// Assignment #: 8
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: 10:45 AM MWF
//  Description: The class compares movies based on year
import java.util.*;

public class MovieYearComparator implements Comparator<Movie>{
	
	//returns true if the years match
	public int compare(Movie first, Movie second) {
		int result = 0;

			result = Integer.toString(first.getYear()).compareTo(Integer.toString(second.getYear()));
		
		return result;
	}
}
