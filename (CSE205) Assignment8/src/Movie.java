import java.io.Serializable;

// Assignment #: 8
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: 10:45 AM MWF
//  Description: The class Movie represents a Movie.


public class Movie implements Serializable 
 {
   private String movieTitle;
   private int year;
   private int length;
   private Production prodCompany;

   //Constructor to initialize all member variables
   public Movie()
    {
      movieTitle = "?";
      length = 0;
      year = 0;
      prodCompany = new Production();
    }

   //Accessor method for movie title
   public String getMovieTitle()
    {
      return movieTitle;
    }

   //Accessor method for movie length
   public int getLength()
    {
      return length;
    }

   //Accessor method for movie year
   public int getYear()
    {
	   return year;
	}

   //Accessor method for production company
   public Production getProdCompany()
    {
      return prodCompany;
    }

   //Mutator method for movie title
   public void setMovieTitle(String aTitle)
    {
     movieTitle = aTitle;
    }

   //Mutator method for movie length
   public void setLength(int aLength)
    {
     length = aLength;
    }

   //Mutator method for movie year
   public void setYear(int aYear)
    {
        year = aYear;
    }

   //Mutator method for production company
   public void setProdCompany(String name, String city, String state)
    {
        prodCompany.setCompanyName(name);
        prodCompany.setLocationCity(city);
        prodCompany.setLocationState(state);
    }

   //toString() method returns a string containg its name, number, location and budget
   public String toString()
    {
      String result = "\nMovie Title:\t\t" + movieTitle
                    + "\nMovie Length:\t\t" + length
                    + "\nMovie Year:\t\t" + year
                    + "\nMovie Production:\t"
                    + prodCompany.toString() + "\n\n";
      return result;
     }
  }
