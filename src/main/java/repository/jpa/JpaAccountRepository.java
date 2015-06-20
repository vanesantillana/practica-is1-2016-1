package repository.jpa;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.AccountRepository;
import domain.Account;

@Repository
public class JpaAccountRepository extends JpaBaseRepository<Account, Long> implements
		AccountRepository {

	@Override
	public Account findByNumber(String number) {
		String jpaQuery = "SELECT a FROM Account a WHERE number = :number";
		TypedQuery<Account> query = entityManager.createQuery(jpaQuery, Account.class);
		query.setParameter("number", number);
		return getFirstResult(query);
	}
}
