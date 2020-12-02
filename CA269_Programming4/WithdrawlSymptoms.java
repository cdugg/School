public class BankAccount {
	double balance;
	public BankAccount(double bal)
	{
		balance = bal;
	}
	public void withdraw(double amount)
	{
		balance = balance - amount;
	}
}
