package tech.asmussen.bank;

public enum Currency {
	
	USD("$"),
	EUR("€"),
	DKK("kr.");
	
	private final String symbol;
	
	Currency(String symbol) {
		
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		
		return symbol;
	}
}
