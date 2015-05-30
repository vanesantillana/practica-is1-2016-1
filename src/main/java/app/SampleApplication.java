package app;

import repository.AccountRepository;
import repository.InMemoryAccountRepository;
import service.TransferService;
import domain.Account;

//@Import(WebConfig.class)
//@EnableAutoConfiguration
public class SampleApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(SampleApplication.class, args);
		AccountRepository repository = new InMemoryAccountRepository();
		TransferService service = new TransferService(repository);
		Account a1 = new Account("1001", 550);
		Account a2 = new Account("1002", 50);
		System.out.println(a1);
		System.out.println(a2);
		repository.save(a1);
		repository.save(a2);
		service.transfer("1001", "1002", 100);
		System.out.println(repository.findAll());
	}
}
