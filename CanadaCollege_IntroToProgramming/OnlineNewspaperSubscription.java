//Cormac Duggan
//Lab 13
//Online subscription subclass
public class OnlineNewspaperSubscription extends NewspaperSubscription 
{

	@Override
	public int setAddress(String add) 
	{
		int price;
		if (add.matches ("[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		{
			price = 9;
		}
		else
		{
			price = 0;
		}
		return price;
	}
}