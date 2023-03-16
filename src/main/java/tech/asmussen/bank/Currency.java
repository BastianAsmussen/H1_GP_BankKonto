package tech.asmussen.bank;

public enum Currency {
	
	USD("$", true, 1),
	EUR("€", true, 0.94),
	DKK(" kr.", false, 0.14),
	BTC("₿", true, 24_657.20);
	
	private final String symbol;
	private final boolean isPrefixSymbol;
	
	private final double exchangeRate; // Price of 1 USD in this currency.
	
	Currency(String symbol, boolean isPrefixSymbol, double exchangeRate) {
		
		this.symbol = symbol;
		this.isPrefixSymbol = isPrefixSymbol;
		
		this.exchangeRate = exchangeRate;
	}
	
	public String getSymbol() {
		
		return symbol;
	}
	
	public boolean isPrefixSymbol() {
		
		return isPrefixSymbol;
	}
	
	public double getExchangeRate() {
		
		return exchangeRate;
	}
	
	/**
	 * Converts an amount of money from this currency to another currency.
	 *
	 * @param amount     The amount of money to convert.
	 * @param toCurrency The currency to convert to.
	 * @return The converted amount of money.
	 */
	public double convert(double amount, Currency toCurrency) {
		
		return amount * exchangeRate / toCurrency.exchangeRate;
	}
	
	public String format(double amount) {
		
		// symbols[0] = prefix, symbols[1] = suffix.
		String[] symbols = new String[] {
				isPrefixSymbol ? symbol : "",
				isPrefixSymbol ? "" : symbol
		};
		
		return String.format("%s%.2f%s", symbols[0], amount, symbols[1]);
	}
	
	@Override
	public String toString() {
		
		return name() + " (" + symbol + ")";
	}
}
