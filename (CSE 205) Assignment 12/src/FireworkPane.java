// Assignment #: Arizona State University CSE205 #12
//         Name: Yisha Fan
//    StudentID: 1214976529
//      Lecture: MWF 10:45AM
//  Description: The FireworkPane class draws the beams


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;


public class FireworkPane extends Pane{

	
	private Color color; // color of the beams
	private Timeline timeline1; // an object of timer 
	private int step; // step that beams move 
	private int centerX; // x coordinate of the beams
	private int centerY; // y coordinate of the beams
	private double radiusLimit; // longest diameter of beams
	private double radius; // diameters of the beams
	private int beamNum; // amount of beams
	private double angleSize; // angle size of each beam

	// constructor for the class
	public FireworkPane(Color color, int width)
	{
		this.color = color;
		step = 3;
		//setBackgroundColor(Color.BLACK);
		centerX = width/2;
		centerY = width/2;
		radiusLimit = (width - 10)/(4.0);
		radius = 0;
		beamNum = 8;
		angleSize = 360/(beamNum * 2);
		
		setStyle("-fx-background-color: black;");
		
		for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
		  {
		    Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
		    arc1.setFill(color);
		    arc1.setStroke(color);
		    arc1.setType(ArcType.ROUND);
		    this.getChildren().add(arc1);
		   }
		
		KeyFrame kf = new KeyFrame(Duration.millis(500), new FireworkHandler());
		timeline1 = new Timeline(kf);
		timeline1.setCycleCount(Timeline.INDEFINITE);
		timeline1.setRate(20);
		timeline1.play();
		
		

	}
	// method that resumes the timer
	public void resume()
	{
		timeline1.play();
	}
	// method that stops the timer
	public void suspend()
	{
		timeline1.pause();
	}
	// changes the color of the beams
	public void changeColor(Color anotherColor)
	{
		color = anotherColor;
	}
	// sets the number of beams
	public void setBeamNumber(int beam)
	{
		beamNum = beam;
		angleSize = (360.0)/(beamNum*2);
	}
	// set rate of the beams
	public void setRate(int rate1)
	{
		timeline1.setRate(rate1);
	}
	
	//class to handle the fireworks
	private class FireworkHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent Event) {
			
			radius = radius+step;
			//sets radius to zero if it becomes greater than the limit
			if(radius > radiusLimit) {
				radius = 0;
				
				}
				getChildren().clear(); 
				angleSize = 360/(beamNum*2);
				
				//adds arcs 
				for (int currentAngle=0; currentAngle <= 360; currentAngle += 2*angleSize)
			      {
			        Arc arc1 = new Arc(centerX, centerY, radius, radius, currentAngle, angleSize);
			        arc1.setFill(color);
			        arc1.setStroke(color);
			        arc1.setType(ArcType.ROUND);
			        getChildren().add(arc1);
			      }

			
			
		}
		
	}


}
