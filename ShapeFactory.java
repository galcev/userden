/**
 * @author Galcev
 * @versin 1.0
 * 
 * This file contains the creation of objects, drawing objects. Constructive selects through switch statement
 */

import java.awt.*;
import java.awt.geom.GeneralPath;

public class ShapeFactory {
	public java.awt.Shape shape;
	  public java.awt.BasicStroke stroke;
	  public java.awt.Paint paint;
	  public int width = 25;
	  public int height = 25;

/**
 *BasicStroke
 *public BasicStroke(float width)
 *(Constructs a solid BasicStroke with the specified line width and with default values for the cap and join styles.)
 *@Param: width - the width of the BasicStroke
 * 
 * 
 * 
 *public GeneralPath()
 *Constructs a new empty single precision GeneralPath object with a default winding rule of 
 * 
 * 
 * 
 *moveTo
 *public abstract void moveTo(double x, double y)
 *(Adds a point to the path by moving to the specified coordinates specified in double precision.
 *@param: x - the specified X coordinatey - the specified Y coordinate
 * 
 * 
 * 
 *lineTo
 *public final void lineTo(double x, double y)
 *(Adds a point to the path by drawing a straight line from the current coordinates to the new specified coordinates specified in double precision.)
 *@Param: x - the specified X coordinatey - the specified Y coordinate
 */
	 	
	
	
	
	  public ShapeFactory(int shape_type) {
	    stroke = new java.awt.BasicStroke(3.0F);
	    switch (shape_type / 10) {
	    case 1: 
	      shape = createStar(3, new Point(0, 0), width / 2.0D, width / 2.0D);
	      break;
	    case 3: 
	      shape = createStar(5, new Point(0, 0), width / 2.0D, width / 4.0D);
	      break;
	    case 5: 
	      shape = new java.awt.geom.Rectangle2D.Double(-width / 2.0D, -height / 2.0D, width, height);
	      break;
	    case 7: 
	      GeneralPath path = new GeneralPath();
	      double tmp_height = Math.sqrt(2.0D) / 2.0D * height;
	      path.moveTo(-width / 2, -tmp_height);
	      path.lineTo(0.0D, -tmp_height);
	      path.lineTo(width / 2, tmp_height);
	      path.closePath();
	      shape = path;
	      break;
	    case 9: 
	      shape = new java.awt.geom.Arc2D.Double(-width / 2.0D, -height / 2.0D, width, height, 30.0D, 300.0D, 
	        2);
	      break;
	    case 2: case 4: case 6: 
	    case 8: default: 
	      throw new Error("type is nusupported");
	    }
	    switch (shape_type % 10) {
	    case 1:  stroke = new java.awt.BasicStroke(7.0F);
	      break;
	    case 3: 
	      break;
	    case 4:  stroke = new java.awt.BasicStroke(7.0F);
	      break;
	    case 8: 
	      paint = new java.awt.GradientPaint(
	        -width, -height, java.awt.Color.white, 
	        width, height, java.awt.Color.gray, true);
	      break;
	    case 7: 
	      paint = java.awt.Color.red;
	      break;
	    case 2: case 5: case 6: default: 
	      throw new Error("type is nusupported");
	    }
	  }
	  
	  private static java.awt.Shape createStar(int arms, Point center, double rOuter, double rInner)
	  {
	    double angle = 3.141592653589793D / arms;
	    
	    GeneralPath path = new GeneralPath();
	    int x=0, y=0;
	    for (int i = 0; i < 2 * arms; i++)
	    {
	      double r = (i & 0x1) == 0 ? rOuter : rInner;
	      java.awt.geom.Point2D.Double p = new java.awt.geom.Point2D.Double(x + Math.cos(i * angle) * r, y + Math.sin(i * angle) * r);
	      if (i == 0) path.moveTo(p.getX(), p.getY()); 
	      else
	        path.lineTo(p.getX(), p.getY());
	    }
	    path.closePath();
	    return path;
	  }
}
