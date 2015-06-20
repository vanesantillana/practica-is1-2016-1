package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Import;

import config.WebConfig;
import domain.BaseEntity;

@Import(WebConfig.class)
@EnableAutoConfiguration
@EntityScan(basePackageClasses=BaseEntity.class)
public class BankApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BankApplication.class, args);
//		AccountRepository repository = new InMemoryAccountRepository();
//		TransferService service = new TransferService(repository);
//		Account a1 = new Account("1001", 550);
//		Account a2 = new Account("1002", 50);
//		System.out.println(a1);
//		System.out.println(a2);
//		repository.save(a1);
//		repository.save(a2);
//		service.transfer("1001", "1002", 100);
//		System.out.println(repository.findAll());
	}
}
