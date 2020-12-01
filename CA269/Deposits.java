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
	public void deposit(double amount)
	{
		balance = balance + amount;
	}
}
