package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account implements BaseEntity<Long> {

	@Id
	@SequenceGenerator(name = "account_id_generator", sequenceName = "account_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_generator")
	private Long id;

	@Column(unique = true, nullable = false, updatable = false)
	private String number;

	@Column(nullable = false)
	private double balance;

	public Account() {
	}

	public Account(String number, double balance) {
		this.number = number;
		this.balance = balance;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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
