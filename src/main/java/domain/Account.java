package domain;

public class Account {
	private String number;
	private double balance;

	public Account() {
	}

	public Account(String number, double balance) {
		this.number = number;
		this.balance = balance;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public static Account copy(Account account) {
		if (account == null) {
			return null;
		}
		Account copy = new Account();
		copy.setBalance(account.getBalance());
		copy.setNumber(account.getNumber());
		return copy;
	}
	
	@Override
	public String toString() {
		return "{number: " + number + ", balance: " + balance + "}";
	}
}
