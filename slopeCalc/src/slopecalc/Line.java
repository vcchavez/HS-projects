
package slopecalc;

/**
 *
 * @author vcchavez
 */
public class Line
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;  
    
    /** Creates a new default instance of Line */
    public Line()
    {
        //need default values for x1,y1 and x2,y2
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }
    
    public Line(int newX1, int newY1, int newX2, int newY2)
    {
        //insert code here
        x1 = newX1;
        y1 = newY1;
        x2 = newX2;
        y2 = newY2;
    }
    
    public double getSlope()
    {
        //insert code to compute slope
        double m = ((double) (y2 - y1)) / (x2 - x1);
        return m;
    }

    public double getDistance()
    {
        //insert code to compute distance
        double dist = Math.sqrt((x2-x1) * (x2-x1) + (y2-y1) * (y2-y1));
        return dist;
    }
    
    public String toString()
    {
        return "pt1: (" + x1 + ", " + y1 + ") pt2: (" + x2 + ", " + y2 + ")";
    }
}
