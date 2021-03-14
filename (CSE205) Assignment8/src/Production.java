// Assignment #: 8
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: 10:45 MWF
//  Description: The Production class describes a Production.
//               It also provides their accessor, mutator methods,
//               and toString method.

public class Production
 {
 private String companyName;
 private String locationCity;
 private String locationState;

 //Constructor method to initialize intance variables.
 public Production()
  {
      companyName = new String("?");
      locationCity= new String("?");
      locationState = new String("?");
  }

 //Accessor method for companyName
 public String getCompanyName()
  {
   return companyName;
  }

 //Accessor method for locationCity
 public String getLocationCity()
  {
   return locationCity;
  }

 //Accessor method for locationState
 public String getLocationState()
  {
    return locationState;
  }

 //Mutator method for companyName
 public void setCompanyName(String someCompanyName)
  {
   companyName = someCompanyName;
  }

 //Mutator method for locationCity
 public void setLocationCity(String someLocationCity)
  {
   locationCity = someLocationCity;
  }

 //Mutator method for locationState
 public void setLocationState(String someLocationState)
  {
    locationState = someLocationState;
  }

 //This method return a string containing the attribute information of a Production
 public String toString()
  {
   String result;

      result = companyName + " at " + locationCity + "," + locationState;

   return result;
  }
} 


