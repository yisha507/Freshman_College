// Assignment #: 4
// Name: Yisha Fan
// StudentID: 1214976529
// Lecture: MWF 10:45
//Description:  
public class Movie {
	
	//instantiates variables
	private String movieTitle;
	private int year;
	private int length;
	private Production prodCompany;
	
	//constructor
	public Movie() {
		movieTitle = "?";
		year = 0;
		length = 0;
		prodCompany =  new Production();
	}
	
	//returns movie title
	public String getMovieTitle() {
		return movieTitle;
	}
	
	//returns year
	public int getYear() {
		return year;
	}
	
	//returns length
	public int getLength() {
		return length;
	}
	
	//returns production company
	public Production getProdCompany() {
		return prodCompany;
	}
	
	//sets movie title
	public void setMovieTitle(String someTitle) {
		movieTitle = someTitle; 
	}
	
	//sets year of movie
	public void setYear(int someYear) {
		this.year = someYear;
	}
	
	//sets length of movie
	public void setLength(int someLength) {
		this.length = someLength;
	}
	
	//sets production company 
	public void setProdCompany(String name, String city, String state) {
		prodCompany = new Production();
		prodCompany.setCompanyName(name);
		prodCompany.setLocationCity(city);
		prodCompany.setLocationState(state);
	}
	
	//return String 
	public String toString() {
		return "\nMovie Title:\t\t" + movieTitle +"\n" + 
				"Movie Length:\t\t" + length + "\n" + 
				"Movie Year:\t\t"+ year + "\n" + 
				"Movie Production:\t" + prodCompany + "\n\n";
	}
}
