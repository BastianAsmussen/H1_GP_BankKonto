import tech.asmussen.bank.BankAccount;
import tech.asmussen.bank.Currency;

public class Main {
	
	public static void main(String[] args) {
		
		BankAccount jerry = new BankAccount("Jerry", Currency.USD, 100);
		BankAccount chad = new BankAccount("Chad", Currency.BTC, 0xFFFF); // Very rich guy, he has 65.535 BTC.
		
		printBalance(jerry);
		printBalance(chad);
		
		// Chad sends 1 BTC to Jerry.
		chad.transfer(jerry, 1);
		
		printBalance(jerry);
		printBalance(chad);
		
		// Jerry sends 10 USD to Chad and changes his currency to EUR.
		jerry.transfer(chad, 10);
		jerry.setCurrency(Currency.EUR);
		
		printBalance(jerry);
		printBalance(chad);
		
		// Chad changes his currency to DKK.
		chad.setCurrency(Currency.DKK);
		
		printBalance(jerry);
		printBalance(chad);
	}
	
	public static void printBalance(BankAccount account) {
		
		System.out.printf("%s's balance: %s\n",
						  account.getName(),
						  account.getCurrency().format(account.getBalance()));
	}
}
