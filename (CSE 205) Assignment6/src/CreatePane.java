// Assignment #: Arizona State University CSE205
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM
//  Description: CreatePane generates a pane where a user can enter
//  a movie information and create a list of available movies.

import java.util.ArrayList;


import javafx.scene.layout.HBox;

//import all other necessary javafx classes here
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CreatePane extends HBox
{
    
    //The relationship between CreatePane and ReviewPane is Aggregation
    private ReviewPane reviewPane;
    private ArrayList<Movie> movieList;
    private Label title, length, year, message;
    private TextField titleField, lengthField, yearField;
    private Button btn1;
    private TextArea infoDisplay;
    private ReviewPane object;
    //constructor
    public CreatePane(ArrayList<Movie> list, ReviewPane rePane)
     {
        this.movieList = list;
        this.reviewPane = rePane;

        //Step #1: initialize each instance variable and set up the layout
        title = new Label("Title");
        length = new Label("Length");
        year = new Label("Year");
        message = new Label("");
        
        titleField = new TextField();
        lengthField = new TextField();
        yearField = new TextField();
        
        btn1 = new Button("Create a Movie");
        Color red = new Color(0.9, 0,0, 0.8);
        message.setTextFill(red);
        //create a GridPane hold those labels & text fields
        //consider using .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        
        
        //Set up the layout for the left half of the CreatePane.
        grid.add(message, 3, 2);
        grid.add(title, 2, 4); 
        grid.add(length, 2, 5);
        grid.add(year, 2, 6); 
        grid.add(titleField, 3, 4); 
        grid.add(lengthField, 3, 5);
        grid.add(yearField, 3, 6);
        grid.add(btn1, 3, 7);
        
        //the right half of this pane is simply a TextArea object
        //Note: a ScrollPane will be added to it automatically when there are no
        //enough space
        infoDisplay = new TextArea("No Movie");
        
        //Add the left half and right half to the CreatePane
        //Note: CreatePane extends from HBox
        
        this.getChildren().addAll(grid,infoDisplay);
        
        //Step #3: register source object with event handler
        ButtonHandler btnHandle = new ButtonHandler();
        btn1.setOnAction(btnHandle);
        
    } //end of constructor

    //Step 2: Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create a Movie" is pushed or not,
    //When the event occurs, it get a movie's Title, Year, and Length
    //information from the relevant text fields, then create a new movie and add it inside
    //the movieList. Meanwhile it will display the movie's information inside the text area.
    //It also does error checking in case any of the textfields are empty or non-numeric string is typed
    private class ButtonHandler implements EventHandler<ActionEvent>
     {
        //Override the abstact method handle()
        public void handle(ActionEvent event)
         {
            //declare any necessary local variables here
        	Object action = event.getSource();
        	String titleText = ""; 
        	String lengthText = ""; 
        	String yearText = "";
            String movieInfo = "";
        	//when a text field is empty and the button is pushed
            if ( action == btn1 )
                {
            		titleText = titleField.getText();
            		lengthText = lengthField.getText();
            		yearText = yearField.getText();
                    movieInfo = infoDisplay.getText();
                    
            		if(titleText.length() == 0 || lengthText.length() ==0 || yearText.length() == 0) 
                    	message.setText("Please fill all fields");
            		else	//for all other cases
                    {
                    	Movie movie = new Movie();
                    	movie.setMovieTitle(titleText);
                    	
                    	//try catch statement
                        try
                        {
                        	movie.setLength(Integer.valueOf(lengthText));
                        	movie.setYear(Integer.valueOf(yearText));
                       
                        }catch (NumberFormatException e) {
                        	message.setText("Incorrect data format");
                        }
                        //at the end, don't forget to update the new arrayList
                        //information on the ListView of the ReviewPane
                        //----
                        movie.setLength(Integer.parseInt(lengthText));
                        movie.setMovieTitle(titleText);
                        movie.setYear(Integer.parseInt(yearText));
                        
                        //calls on updateMovieList method in class ReviewPane
                        object = new ReviewPane(movieList);
                        object.updateMovieList(movie);
                        
                        message.setText("Movie Added");
                        titleField.setText("");
                        lengthField.setText("");
                        yearField.setText("");
                        
                        
                        if(movieInfo.equals("No Movie")) {
                        	infoDisplay.setText(movie.toString());
                        }
                       
                        else {
                        	infoDisplay.appendText(movie.toString());
                        }
                    
                    }    	
         
                }
         } //end of handle() method
   } //end of ButtonHandler class
}
