package tech.asmussen.bank;

public final class BankAccountManager {
	
	private static long nextId = 0;
	
	public static long getNextId() {
		
		return nextId++;
	}
	
	public static void reset() {
		
		nextId = 0;
	}
}
