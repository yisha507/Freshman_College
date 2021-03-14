import java.util.Comparator;

// Assignment #: 8
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: 10:45 AM MWF
//  Description: The class compares the titles of movies
public class MovieTitleComparator implements Comparator<Movie> {
	
	//returns true if the titles match
	public int compare(Movie first, Movie second) {
		int result = 0;

			result = first.getMovieTitle().compareTo(second.getMovieTitle());

		return result;
	}
}
