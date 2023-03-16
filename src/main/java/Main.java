import tech.asmussen.bank.BankAccount;
import tech.asmussen.bank.Currency;

public class Main {
	
	public static void main(String[] args) {
		
		BankAccount johnDoe = new BankAccount("John Doe", Currency.USD, 100);
		BankAccount janeDoe = new BankAccount("Jane Doe");
		
		System.out.println("John Doe's account: " + johnDoe);
		System.out.println("Jane Doe's account: " + janeDoe);
	}
}
