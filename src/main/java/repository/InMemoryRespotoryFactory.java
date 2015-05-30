package repository;

public class InMemoryRespotoryFactory implements RepositoryFactory {

	@Override
	public AccountRepository createAccountRepository() {
		return new InMemoryAccountRepository();
	}

	@Override
	public PersonRepository createPersonRepository() {
		return null;
	}

}
