package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Account;

public class InMemoryAccountRepository implements AccountRepository {

	Map<String, Account> accounts;

	public InMemoryAccountRepository() {
		accounts = new HashMap<String, Account>();
	}

	@Override
	public Account findByNumber(String number) {
		return Account.copy(accounts.get(number));
	}

	@Override
	public List<Account> findAll() {
		List<Account> list = new ArrayList<Account>();
		for (Account a : accounts.values()) {
			list.add(Account.copy(a));
		}
		return list;
	}

	@Override
	public Account save(Account account) {
		if (account.getNumber() == null)  {
			account.setNumber("" + (int)(100000 + 1000000*Math.random()));
		}
		accounts.put(account.getNumber(), account);
		return Account.copy(account);
	}

	@Override
	public Account remove(Account account) {
		if (accounts.containsKey(account.getNumber()))
			return Account.copy(accounts.remove(account.getNumber()));
		return null;
	}
	
}
