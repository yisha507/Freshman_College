// Assignment #: 8
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: 10:45 MWF
//  Description: The class arranges movieList based on certain specifications
public class MovieArrangement {

	private Movie[] movieList;
	private int currentMoviesCount;
	private int maxSize;
	private Movie[] temp;
	//A Constructor of the MovieArrangement class.
	public MovieArrangement(int maximumsize) {
		maxSize = maximumsize;
		movieList = new Movie[maxSize];
		currentMoviesCount = 0;
	}
	
	//Search for a Movie object by movieTitle and its year, and return the index of the object if found.
	public int movieExists(String movieTitle, int year) {
		for(int i = 0; i < currentMoviesCount; i++) {
			
			if(movieList[i] != null) {
				
				if(movieList[i].getMovieTitle().equals(movieTitle) && movieList[i].getYear()==(year))
					return 1;
			}
		}
		return -1;
	}
	
	//Search for a Movie object in the movie list that have the same company name, city, and state as the parameter values and return the index of such object if found. 
	public int productionExists(String companyName, String locationCity, String locationState) {
		for(int i = 0; i < currentMoviesCount; i++) {
			
			if(movieList[i] != null) {
				
				if(movieList[i].getProdCompany().getCompanyName().equals(companyName) && movieList[i].getProdCompany().getLocationCity().equals(locationCity) &&movieList[i].getProdCompany().getLocationState().equals(locationState))
					return 1;
			}
		}
		return -1;
	}
	
	//Add a Movie object to the movie list and return true if such object was added successfully
	public boolean addMovie(String title, int length, int year, String companyName, String locationCity, String locationState) {
		boolean flag = false;
		Movie movie = new Movie();
		movie.setMovieTitle(title);
		movie.setLength(length);
		movie.setYear(year);
		movie.setProdCompany(companyName, locationCity, locationState);
		
		//calls on methods to determine if a duplicate exists
		int movieNum = movieExists(title,year);
		int prodNum = productionExists(companyName, locationCity,locationState);
		
			if((movieNum == -1 && prodNum == -1) && currentMoviesCount < maxSize) {
				flag = true;
				movieList[currentMoviesCount] = movie;
				currentMoviesCount++;
				
			}
			else
				flag = false;
			
		return flag;
		
	}
	
	//Remove a Movie object of the parameter movieTitle and the year from the movie list.
	public boolean removeMovie(String movieTitle, int year) {
		boolean flag = false;
		temp = new Movie[currentMoviesCount -1];
		
		int j = 0;
		for(int i = 0; i <= currentMoviesCount; i++){
		    if(movieList[i].getMovieTitle().equals(movieTitle) && movieList[i].getYear() == year){
		        i++;
		        flag = true;
		    }else{
		        temp[j] = movieList[i];
		        j++;
		    }
		}
		movieList = temp;
		currentMoviesCount--;	
		return flag;
	}
	
	//Sort the list of Movie objects by movie titles.
	public void sortByMovieTitles() {
		MovieTitleComparator comp = new MovieTitleComparator();
		Sorts.sort(movieList, currentMoviesCount, comp);
	}
	
	//Sort the list of Movie objects by movie years.
	public void sortByMovieYears() {
		MovieYearComparator comp = new MovieYearComparator();
		Sorts.sort(movieList, currentMoviesCount, comp);
	}
	
	//Sort the list of Movie objects by their production information including its city and state
	public void sortByProductions() {
		ProductionLocationComparator comp = new ProductionLocationComparator();
		Sorts.sort(movieList, currentMoviesCount, comp);
	}
	
	//List all Movie objects in the movie list.
	public String listMovies() {
		String allMovies ="";
		
		if(currentMoviesCount == 0) {
			allMovies = "\nno movie\n\n";
		}
		for(int i = 0; i < currentMoviesCount; i++) {
			
			if(currentMoviesCount == 0) {
				allMovies = "\nno movie\n\n";	
				break;
			}
			allMovies += movieList[i];
		}
		
		
		return allMovies;
	}
	
	//Closes the movie arrangement system by making the movieList empty.
	public void closeMovieArrangement() {
		currentMoviesCount = 0;
	}
}
