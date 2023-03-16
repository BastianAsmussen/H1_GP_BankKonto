import tech.asmussen.bank.BankAccount;
import tech.asmussen.bank.Currency;

public class Main {
	
	public static void main(String[] args) {
		
		BankAccount jerry = new BankAccount("Jerry", Currency.USD, 100);
		BankAccount chad = new BankAccount("Chad", Currency.BTC, 3);
		
		System.out.printf("Jerry's balance: %s\n", jerry.getCurrency().format(jerry.getBalance()));
		System.out.printf("Chad's balance: %s.\n", chad.getCurrency().format(chad.getBalance()));
		
		// Chad sends 1 BTC to Jerry.
		chad.transfer(jerry, 1);
		
		System.out.printf("Jerry's balance: %s\n", jerry.getCurrency().format(jerry.getBalance()));
		System.out.printf("Chad's balance: %s.\n", chad.getCurrency().format(chad.getBalance()));
		
		// Jerry sends 10 USD to Chad.
		jerry.transfer(chad, 10);
		
		System.out.printf("Jerry's balance: %s\n", jerry.getCurrency().format(jerry.getBalance()));
		System.out.printf("Chad's balance: %s.\n", chad.getCurrency().format(chad.getBalance()));
		
		// Chad changes his currency to DKK.
		chad.setCurrency(Currency.DKK);
		
		System.out.printf("Jerry's balance: %s\n", jerry.getCurrency().format(jerry.getBalance()));
		System.out.printf("Chad's balance: %s\n", chad.getCurrency().format(chad.getBalance()));
	}
}
