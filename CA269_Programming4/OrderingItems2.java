public class Point implements Order
{
    private double x, y;
    
    public Point(double newX, double newY)
    {
        x = newX;
        y = newY;
    }
    
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
    public boolean lessThan(Order other)
    {
    	Point p = (Point) other;
    	if(java.lang.Math.abs(x) +  java.lang.Math.abs(y) <  java.lang.Math.abs(p.x) +  java.lang.Math.abs(p.y))
    		return true;
    	return false;  	
    }
}
