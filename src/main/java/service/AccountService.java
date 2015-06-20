package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.AccountRepository;
import domain.Account;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;

	@Transactional
	public void save(Account account) {
		repository.persist(account);
	}
}
