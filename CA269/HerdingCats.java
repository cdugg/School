public class Cat implements Order
{
    private String name;
    
    public Cat(String n)
    {
        name = n;
    }
    
    public String toString()
    {
        return "Cat: " + name;
    }
    public boolean lessThan(Order p)
    {
    	Cat b = (Cat) p;
    	if(name.length() < b.name.length())
    		return true;
    	return false;
    }
}
