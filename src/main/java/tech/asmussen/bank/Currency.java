package tech.asmussen.bank;

import java.text.DecimalFormat;

public enum Currency {
	
	USD("$", true, 1),
	EUR("€", false, 0.94),
	DKK(" kr.", false, 0.14),
	BTC("₿", false, 24_657.2);
	
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
		
		final DecimalFormat formatter = new DecimalFormat("#,###.##");
		
		// symbols[0] = prefix, symbols[1] = suffix.
		final String[] symbols = new String[] {
				isPrefixSymbol ? symbol : "",
				isPrefixSymbol ? "" : symbol
		};
		
		return String.format("%s%s%s", symbols[0], formatter.format(amount), symbols[1]);
	}
	
	@Override
	public String toString() {
		
		return name() + " (" + symbol + ")";
	}
}
