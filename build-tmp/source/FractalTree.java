import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 10; 
private double branchAngle = .8f;  
public void setup() 
{   
	size(640,960);    
	noLoop(); 
} 
public void draw() 
{   
	background(0);   
	stroke(0, 0, 255);   
	line(320,520,320,620);   
	drawBranches(320, 620, 100, Math.PI/2, .8f);  //will add later 
	stroke(0, 255, 0);
	line(320, 520, 320, 420);
	drawBranches(320, 420, 100, 3*Math.PI/2, .4f);
} 
public void drawBranches(int x,int y, double branchLength, double angle, double bAngle) 
{   
	double angle1 = angle + bAngle;
	double angle2 = angle - bAngle;
	branchLength *= fractionLength;
	int endX1 = (int)(branchLength*Math.cos(angle1) + x);
	int endY1 = (int)(branchLength*Math.sin(angle1) + y);
	int endX2 = (int)(branchLength*Math.cos(angle2) + x);
	int endY2 = (int)(branchLength*Math.sin(angle2) + y);
	line(x, y, endX1, endY1);
	line(x, y, endX2, endY2);
	if (branchLength > smallestBranch) {
		//drawBranches(endX1, endY1, branchLength, angle + radians(  (float)(Math.random()*100))  );
		//drawBranches(endX2, endY2, branchLength, angle - radians(  (float)(Math.random()*100))  );
		drawBranches(endX1, endY1, branchLength, angle1, bAngle );
		drawBranches(endX2, endY2, branchLength, angle2, bAngle );
	}
	  
} 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
