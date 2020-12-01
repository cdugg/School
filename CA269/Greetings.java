public class Cat implements Polite
{
    private String name;
    
    public Cat(String n)
    {
        name = n;
    }
    
    public String toString()
    {
        return "cat: " + name;
    }
    public void hello()
    {
    	System.out.print("hello");
    }
}
