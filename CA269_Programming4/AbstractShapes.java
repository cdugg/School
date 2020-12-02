public class Average
{
    public static double averageArea(Shape [] shape)
    {
        double aver = 0;
        for(int i = 0; i < shape.length; i ++)
        {
            aver += shape[i].area();
        }
        return aver/shape.length;
    }
}
