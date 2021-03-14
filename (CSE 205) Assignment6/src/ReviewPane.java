// Assignment #: 6 Arizona State University CSE205
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45 AM
//  Description: ReviewPane displays a list of available movies
//  from which a user can select to review.


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.HBox;

//import all other necessary javafx classes here
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleGroup;


public class ReviewPane extends VBox
{
   private ArrayList<Movie> movieList;
   
   //A ListView to display movies created
   private ListView<Movie> movieListView;

   //declare all other necessary GUI variables here
   private RadioButton rating1, rating2, rating3,rating4,rating5; 
   private Button submitBtn; 
   private Label instructions;

   private ObservableList<String> obsList;
   //constructor
   public ReviewPane(ArrayList<Movie> list)
   {
       //initialize instance variables
       this.movieList = list;
       movieList = new ArrayList<Movie>();
       
       //set up the layout
       instructions = new Label("Choose a movie to give a review, and select a rating:");
       
       rating1 = new RadioButton("1 Poor");
       rating2 = new RadioButton("2 Fair");
       rating3 = new RadioButton("3 Average");
       rating4 = new RadioButton("4 Good");
       rating5 = new RadioButton("5 Excellent");
       
       //places radio buttons into a toggle group
       ToggleGroup group = new ToggleGroup();
       rating1.setToggleGroup(group);
       rating2.setToggleGroup(group);
       rating3.setToggleGroup(group);
       rating4.setToggleGroup(group);
       rating5.setToggleGroup(group);
       
       //organizes radio buttons into a HBox
       HBox ratings = new HBox();
       ratings.setSpacing(5);
       ratings.getChildren().addAll(rating1, rating2, rating3, rating4, rating5);
       
       
       //Creates observable list and sets selection mode to single
       obsList = FXCollections.observableArrayList(movieList.toString());
       movieListView = new ListView(obsList);
       movieListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
       
       submitBtn = new Button("Submit Review");
       
       
       
       //ReviewPane is a VBox - add the components here
       this.getChildren().addAll(instructions, movieListView, ratings, submitBtn);
       
       
       //Step #3: Register the button with its handler class
       RatingHandler btnHandle = new RatingHandler();
       submitBtn.setOnAction(btnHandle);
       
       
   } //end of constructor

 //This method refresh the ListView whenever there's new movie added in CreatePane
 //you will need to update the underline ObservableList object in order for ListView
 //object to show the updated movie list
 public void updateMovieList(Movie newMovie)
 {
	 movieList.add(newMovie); 
	 obsList.setAll(movieList.get(0).toString());
 }

 //Step 2: Create a RatingHandler class
 private class RatingHandler implements EventHandler<ActionEvent>
    {
        //Override the abstact method handle()
        public void handle(ActionEvent event)
        {
        	Object action = event.getSource();
        	Movie selected = movieListView.getSelectionModel().getSelectedItem();
            
            
        	//When "Submit Review" button is pressed and a movie is selected from
            //the list view's average rating is updated by adding a additional
            //rating specified by a selected radio button
            if (action == submitBtn) //&& selected.equals(true))
               {
                   if(rating1.isSelected()) {   
                	   selected.addRating(1);
                   }
                   
                   else if(rating2.isSelected()) { 
                	   selected.addRating(2);
                   }
                   
                   else if(rating3.isSelected()) {
                	   selected.addRating(3);
                   }
                   
                   else if(rating4.isSelected()) {
                	   selected.addRating(4);
                   }
                   
                   else if(rating5.isSelected()) {
                	   selected.addRating(5);
                   }
            }
        }
    } //end of RatingHandler
} //end of ReviewPane class
