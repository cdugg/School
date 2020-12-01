//Cormac Duggan
//Lab 13
//Newspaper subscription abstract class
public abstract class NewspaperSubscription 
{
	
	public void getName (String inputName)
	{
		String name = inputName;
	}
	public void getSubRate ()
	{
		subRate = price;
	}
	public String setName()
	{
		return name;
	}
	public void getAddress (String address)
	{
		add = address;
	}
	
	public abstract int setAddress (String add);
	
	public static void something ()
	{
		PhysicalNewspaperSubscription physical = new PhysicalNewspaperSubscription ();
		OnlineNewspaperSubscription online = new OnlineNewspaperSubscription ();
		physical.setAddress(add);
		online.setAddress(add);	
	}
	
}