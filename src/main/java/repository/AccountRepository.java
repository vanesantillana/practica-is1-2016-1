package repository;

import domain.Account;

public interface AccountRepository extends BaseRepository<Account, Long> {
	Account findByNumber(String number);
}
