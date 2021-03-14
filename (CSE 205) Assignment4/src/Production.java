// Assignment #: 4
// Name: Yisha Fan
// StudentID: 1214976529
// Lecture: MWF 10:45
//Description:  
public class Production {
	
	//instantiates variables
	private String companyName;
	private String locationCity;
	private String locationState;
	
	//constructor
	public Production() {
		companyName = "?";
		locationCity = "?";
		locationState = "?";
	}
	
	//returns company name
	public String getCompanyName() {
		return companyName;
	}
	
	//return location of city
	public String getLocationCity() {
		return locationCity;
	}
	
	//return location of state
	public String getLocationState() {
		return locationState;
	}
	
	//sets company name
	public void setCompanyName(String someName) {
		companyName = someName;
	}
	
	//sets location of city
	public void setLocationCity (String someCity) {
		locationCity = someCity;
	}
	
	//sets location of state
	public void setLocationState(String someState) {
		locationState = someState;
	}
	
	//returns String
	public String toString() {
		return getCompanyName() + "at " + getLocationCity() + "," + getLocationState();
	}
	

}
