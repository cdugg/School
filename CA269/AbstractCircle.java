public class Circle extends Shape
{
    private double radius;
    public Circle(String name, Double radius1)
    {
        super(name);
        radius = radius1;
    }
    public double area()
    {
        return Math.PI * radius * radius;
    }
}
