package service;

import repository.AccountRepository;
import domain.Account;

public class TransferService {

	AccountRepository repository;

	public TransferService(AccountRepository repository) {
		this.repository = repository;
	}

	public boolean transfer(String sourceNumber, String targetNumber, double amount) {
		Account sourceAccount = repository.findByNumber(sourceNumber);
		Account targetAccount = repository.findByNumber(targetNumber);
		if (sourceAccount == null || targetAccount == null) {
			System.err.println("No se puede transferir por que no existe una cuenta");
			return false;
		}
		if (sourceAccount.getBalance() >= amount) {
			sourceAccount.setBalance(sourceAccount.getBalance() - amount);
			targetAccount.setBalance(targetAccount.getBalance() + amount);
			repository.save(sourceAccount);
			repository.save(targetAccount);
			return true;
		}
		return false;
	}
}
