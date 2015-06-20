package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AccountService;
import service.TransferService;
import domain.Account;
import form.TransferForm;

@Controller
public class BankController {

	@Autowired
	TransferService transferService;

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	String transfer(@ModelAttribute TransferForm transfer, ModelMap model) {
		transferService.transfer(transfer.getSourceAccountNumber(), transfer.getTargetAccountNumber(), transfer.getAmount());
		return "hello";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	String saveAccount(@ModelAttribute Account account, ModelMap model) {
		accountService.save(account);
		return "hello";
	}

}
