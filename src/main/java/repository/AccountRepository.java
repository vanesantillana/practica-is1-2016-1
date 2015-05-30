package repository;

import java.util.List;

import domain.Account;

public interface AccountRepository {
	Account findByNumber(String number);

	List<Account> findAll();

	Account save(Account account);

	Account remove(Account account);
}
