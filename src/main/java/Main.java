import tech.asmussen.bank.BankAccount;
import tech.asmussen.bank.Currency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static final List<BankAccount> BANK_ACCOUNTS = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("Select an option:");
			System.out.println("1. Create a new account");
			System.out.println("2. Deposit money");
			System.out.println("3. Withdraw money");
			System.out.println("4. Transfer money");
			System.out.println("5. Show balance");
			System.out.println("0. Exit");
			
			System.out.print("> ");
			String rawInput = scanner.nextLine().trim();
			
			int input;
			try {
				
				input = Integer.parseInt(rawInput) % 6;
				
			} catch (NumberFormatException e) {
				
				System.out.println("Invalid input!");
				
				continue;
			}
			
			switch (input) {
				
				case 1 -> { // Create an account.
					
					System.out.print("Enter your name: ");
					String name = scanner.nextLine().trim();
					
					System.out.println("Select a currency:");
					for (int i = 0; i < Currency.values().length; i++) {
						
						System.out.printf("%d. %s\n", i + 1, Currency.values()[i].name());
					}
					
					System.out.print("> ");
					rawInput = scanner.nextLine().trim();
					
					int currencyIndex;
					try {
						
						currencyIndex = Integer.parseInt(rawInput) - 1 % Currency.values().length;
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					Currency currency = Currency.values()[currencyIndex];
					
					BankAccount account = new BankAccount(name, currency, 0);
					
					BANK_ACCOUNTS.add(account);
					
					System.out.println("Account created!");
				}
				
				case 2 -> { // Deposit money.
					
					System.out.print("Enter the account ID: ");
					System.out.println("ID\tName\tBalance\tCurrency");
					for (BankAccount account : BANK_ACCOUNTS) {
						
						System.out.printf("%d\t%s\t%.2f\t%s\n",
										  account.getId(), account.getName(), account.getBalance(), account.getCurrency().name()
						);
					}
					
					System.out.print("> ");
					rawInput = scanner.nextLine().trim();
					
					long accountId;
					try {
						
						accountId = Long.parseLong(rawInput);
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					BankAccount account = BANK_ACCOUNTS.stream()
													   .filter(a -> a.getId() == accountId)
													   .findFirst()
													   .orElse(null);
					
					if (account == null) {
						
						System.out.println("Account not found!");
						
						continue;
					}
					
					System.out.print("Enter the amount: ");
					rawInput = scanner.nextLine().trim();
					
					double amount;
					try {
						
						amount = Double.parseDouble(rawInput);
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					account.deposit(amount);
					
					System.out.println("Deposit successful!");
				}
				
				case 3 -> { // Withdraw money.
					
					System.out.print("Enter the account ID: ");
					System.out.println("ID\tName\tBalance\tCurrency");
					for (BankAccount account : BANK_ACCOUNTS) {
						
						System.out.printf("%d\t%s\t%.2f\t%s\n",
										  account.getId(), account.getName(), account.getBalance(), account.getCurrency().name()
						);
					}
					
					System.out.print("> ");
					rawInput = scanner.nextLine().trim();
					
					long accountId;
					try {
						
						accountId = Long.parseLong(rawInput);
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					BankAccount account = BANK_ACCOUNTS.stream()
													   .filter(a -> a.getId() == accountId)
													   .findFirst()
													   .orElse(null);
					
					if (account == null) {
						
						System.out.println("Account not found!");
						
						continue;
					}
					
					System.out.print("Enter the amount: ");
					rawInput = scanner.nextLine().trim();
					
					double amount;
					try {
						
						amount = Double.parseDouble(rawInput);
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					account.withdraw(amount);
					
					System.out.println("Withdrawal successful!");
				}
				
				case 4 -> { // Transfer money.
					
					/*
					 Display all accounts:
					 ID - Name     - Balance - Currency
					 1  - John Doe - 100.00  - USD
					 2  - Jane Doe - 200.00  - DKK
					 */
					
					System.out.println("Select the account to transfer from:");
					
					System.out.println("ID\tName\tBalance\tCurrency");
					for (BankAccount account : BANK_ACCOUNTS) {
						
						System.out.printf("%d\t%s\t%.2f\t%s\n",
										  account.getId(), account.getName(), account.getBalance(), account.getCurrency().name()
						);
					}
					
					System.out.print("> ");
					rawInput = scanner.nextLine().trim();
					
					long fromAccountId;
					try {
						
						fromAccountId = Long.parseLong(rawInput);
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					BankAccount fromAccount = BANK_ACCOUNTS.stream()
														   .filter(a -> a.getId() == fromAccountId)
														   .findFirst()
														   .orElse(null);
					
					if (fromAccount == null) {
						
						System.out.println("Account not found!");
						
						continue;
					}
					
					System.out.println("Select the account to transfer to:");
					
					System.out.println("ID\tName\tBalance\tCurrency");
					for (BankAccount account : BANK_ACCOUNTS) {
						
						System.out.printf("%d\t%s\t%.2f\t%s\n",
										  account.getId(), account.getName(), account.getBalance(), account.getCurrency().name()
						);
					}
					
					System.out.print("> ");
					rawInput = scanner.nextLine().trim();
					
					long toAccountId;
					try {
						
						toAccountId = Long.parseLong(rawInput);
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					BankAccount toAccount = BANK_ACCOUNTS.stream()
														 .filter(a -> a.getId() == toAccountId)
														 .findFirst()
														 .orElse(null);
					
					if (toAccount == null) {
						
						System.out.println("Account not found!");
						
						continue;
					}
					
					System.out.print("Enter the amount: ");
					rawInput = scanner.nextLine().trim();
					
					double amount;
					try {
						
						amount = Double.parseDouble(rawInput);
						
					} catch (NumberFormatException e) {
						
						System.out.println("Invalid input!");
						
						continue;
					}
					
					fromAccount.transfer(toAccount, amount);
					
					System.out.println("Transfer successful!");
				}
				
				case 5 -> { // Show balance.
					
					System.out.println("ID\tName\tBalance\tCurrency");
					for (BankAccount account : BANK_ACCOUNTS) {
						
						System.out.printf("%d\t%s\t%.2f\t%s\n",
										  account.getId(), account.getName(), account.getBalance(), account.getCurrency().name()
						);
					}
				}
				
				case 0 -> { // Exit.
					
					System.out.println("Goodbye!");
					
					return;
				}
			}
		}
	}
	
	public static void printBalance(BankAccount account) {
		
		System.out.printf("%s's balance: %s\n",
						  account.getName(),
						  account.getCurrency().format(account.getBalance()));
	}
}
