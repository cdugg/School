//Cormac Duggan
//Lab 13
//Physical subscription class
public class PhysicalNewspaperSubscription extends NewspaperSubscription 
{

	@Override
	public int setAddress(String add) 
	{
		int price;
		if (add.matches ("[a-zA-Z]+[0-9]"))
		{
			price = 15;
		}
		else
		{
			price = 0;
		}
		return price;
	}

}