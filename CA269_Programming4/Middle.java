public class Point
{
   private double x;
   private double y;

   public Point(double newX, double newY)
   {
      x = newX;
      y = newY;
   }
   public Point midPoint(Point p2)
   {
	   return new Point((x + p2.x)/2, (y + p2.y)/2);
   }
   public String toString()
   {
      return "(" + x + ", " + y + ")";
   }
}
