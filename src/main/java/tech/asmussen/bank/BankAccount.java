package tech.asmussen.bank;

public class BankAccount {
	
	private final String name;
	private final Currency currency;
	
	private double balance;
	
	public BankAccount(String name, Currency currency, double balance) {
		
		this.name = name;
		this.currency = currency;
		
		this.balance = balance;
	}
	
	public BankAccount(String name) {
		
		this(name, Currency.DKK, 0);
	}
	
	public String getName() {
		
		return name;
	}
	
	public Currency getCurrency() {
		
		return currency;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public void deposit(double amount) {
		
		balance += amount;
	}
	
	public void withdraw(double amount) {
		
		balance -= amount;
	}
	
	public void transfer(BankAccount other, double amount) {
		
		withdraw(amount);
		other.deposit(amount);
	}
	
	@Override
	public String toString() {
		
		return "BankAccount [name=" + name +
				", currency=" + currency +
				", balance=" + balance + "]";
	}
}
