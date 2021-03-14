// Assignment #: Arizona State University CSE205
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45am
//  Description: The DrawingPane class creates a canvas where we can use
//               mouse key to draw lines with different colors and widths.
//               We can also use the the two buttons to erase the last
//				     drawn line or clear them all.


//import any classes necessary here
//----
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent; 	

import java.util.ArrayList;

public class DrawingPane extends BorderPane
{
   private Button undoButton, eraseButton;
   private ComboBox<String> colorCombo, widthCombo;
   private ArrayList<Line> lineList;
   private Pane canvas;
   
   //declare any other necessary instance variables here
   private double x1,y1, x2, y2;
   private Line line;
   private String colorSelect; 
   private int widthSelect;
   
   //Constructor
   public DrawingPane()
   {
      //Step #1: initialize instance variable and set up layout
      undoButton = new Button("Undo");
      eraseButton = new Button("Erase");
      undoButton.setMinWidth(80.0);
      eraseButton.setMinWidth(80.0);
      
      
      //Create the color comboBox and width comboBox,
      colorCombo = new ComboBox<String>();
      widthCombo = new ComboBox<String>();
      
      //adds values to combo boxes for selection
      colorCombo.getItems().addAll("Black","Blue","Red","Yellow","Green");
      widthCombo.getItems().addAll("1","3","5","7");
      
      //sets default selections of color and width of line 
      colorSelect = "Black";
      widthSelect = 1; 
      colorCombo.getSelectionModel().select(colorSelect); 
      widthCombo.getSelectionModel().select(Integer.toString(widthSelect));
      
      //initialize lineList, it is a data structure we used
      //to track the lines we created
      lineList = new ArrayList<Line>();
      
       
      //topPane should contain two combo boxes and two buttons
      HBox topPane = new HBox();
      topPane.setSpacing(40);
      topPane.setPadding(new Insets(10, 10, 10, 10));
      topPane.setStyle("-fx-border-color: black");
      topPane.getChildren().addAll(colorCombo, widthCombo, undoButton, eraseButton); 
      
       //canvas is a Pane where we will draw lines
      canvas = new Pane();
      canvas.setStyle("-fx-background-color: white;");
       

       
      //add the canvas at the center of the pane and top panel
      //should have two combo boxes and two buttons
      this.setCenter(canvas);
      this.setTop(topPane);
      
       
      //Step #3: Register the source nodes with its handler objects
      canvas.setOnMousePressed(new MouseHandler());
      canvas.setOnMouseDragged(new MouseHandler());
      canvas.setOnMouseReleased(new MouseHandler());
      
      undoButton.setOnAction(new ButtonHandler());
      eraseButton.setOnAction(new ButtonHandler());
      
      colorCombo.setOnAction(new ColorHandler());
      widthCombo.setOnAction(new WidthHandler());
   }



    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
            
        	
            //if, statement for when the mouse is pressed
            if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
            {
            	//sets start and end points to the position that is clicked by the mouse
            	x1= event.getX();
            	y1=event.getY();
            	line = new Line();
            	line.setStartX(x1);
            	line.setStartY(y1);
            	
            	line.setEndX(x1);
            	line.setEndY(y1);
            	
            	canvas.getChildren().add(line);
            	line.setStroke(Color.web(colorSelect));
            	line.setStrokeWidth(widthSelect);
            	
            }
            //else if statement for when the mouse is dragged
            else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
            	//sets the end point of the line to where the mouse is currently pointed at
            	x2 = event.getX();
            	y2 = event.getY();
            	line.setEndX(x2);
            	line.setEndY(y2);
            }	
            //else if statement for when the mouse button is released
            else if(event.getEventType() == MouseEvent.MOUSE_RELEASED)
            {
            	//adds the line to the list
            	lineList.add(line);
            } 
            
        }//end handle()
    }//end MouseHandler

    //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
        	
            //if undoButton is pressed
            if(event.getSource() == undoButton)
            {
            	//removes the most recent line from the canvas and from the list
            	canvas.getChildren().remove(lineList.get(lineList.size()-1));
            	lineList.remove(lineList.size()-1);
            	
            }
            
            //if eraseButton is pressed
            if(event.getSource() == eraseButton)
            {
            	//clears all lines and clears the list
            	canvas.getChildren().removeAll(lineList);
            	lineList.clear();
            	
            }
            
        }
    }//end ButtonHandler



   //Step #2(C)- A handler class used to handle colors
   private class ColorHandler implements EventHandler<ActionEvent>
   {
       public void handle(ActionEvent event)
       {
           //changes color of next lines to selected value
           colorSelect = colorCombo.getSelectionModel().getSelectedItem();
           colorCombo.getSelectionModel().select(colorSelect); 
           
       }
   }//end ColorHandler
    
    //Step #2(D)- A handler class used to handle widths of lines
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //changes width of next lines to selected value
        	widthSelect = Integer.parseInt(widthCombo.getSelectionModel().getSelectedItem());
            widthCombo.getSelectionModel().select(Integer.toString(widthSelect));
            
        }
    }//end WidthHandler
}//end class DrawingPane
