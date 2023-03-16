package tech.asmussen.bank;

public class BankAccount {
	
	private final long id;
	
	private final String name;
	
	private Currency currency;
	private double balance;
	
	public BankAccount(String name, Currency currency, double balance) {
		
		id = BankAccountManager.getNextId();
		
		this.name = name;
		
		this.currency = currency;
		this.balance = balance;
	}
	
	public long getId() {
		
		return id;
	}
	
	public String getName() {
		
		return name;
	}
	
	public Currency getCurrency() {
		
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		
		// Convert the balance to the new currency.
		balance = this.currency.convert(balance, currency);
		
		this.currency = currency;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public void deposit(double amount) {
		
		balance += amount;
	}
	
	public void withdraw(double amount) {
		
		if (amount > balance) {
			
			throw new IllegalArgumentException("Cannot withdraw more than the balance!");
		}
		
		balance -= amount;
	}
	
	public void transfer(BankAccount other, double amount) {
		
		// Get the amount in the other account's currency.
		double convertedAmount = currency.convert(amount, other.currency);
		
		// Withdraw from this account.
		withdraw(amount);
		
		// Deposit to the other account.
		other.deposit(convertedAmount);
	}
	
	@Override
	public String toString() {
		
		return "BankAccount { id=%d, name=%s, currency=%s, balance=%f }".formatted(id, name, currency, balance);
	}
}
