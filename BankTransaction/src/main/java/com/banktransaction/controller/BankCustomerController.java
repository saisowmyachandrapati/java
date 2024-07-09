
package com.banktransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banktransaction.entity.BankCustomerDetails;
import com.banktransaction.entity.CreditedDetails;
import com.banktransaction.entity.DebitDetails;
import com.banktransaction.entity.TransactionDetails;
import com.banktransaction.service.BankTransactionService;

@RestController
public class BankCustomerController {

	@Autowired
	BankTransactionService bankCustomerService;

	@PostMapping("/addBankCustomer")    //RegesterCustomerDetails
	public BankCustomerDetails addCustomer(@RequestBody BankCustomerDetails customer) {
		return bankCustomerService.saveCustomer(customer);
	}

	@PostMapping("/addAmount/{accountNumber}/{amount}")  //CreditAmount
	public BankCustomerDetails addAmount(@PathVariable String accountNumber, @PathVariable double amount) {

		return bankCustomerService.addAmount(accountNumber, amount);
	}

	@GetMapping("/getCustomerData")  //Get All CustomerDetails
	public List<BankCustomerDetails> getCustomerData() {
		return bankCustomerService.getCustomer();

	}

	@GetMapping("/getLastrecord/{accountNumber}")   //getLastRecord
	public BankCustomerDetails getLastRecord(@PathVariable String accountNumber) {
		return bankCustomerService.getLatestRecord(accountNumber);
	}

//	@GetMapping("/getMaxId")
//	public int getMaxId() {
//		return bankCustomerService.maxId();
//	}

	@PostMapping("/withdraw/{accountNumber}/{amount}")  //DebitAmount
	public BankCustomerDetails withdrawAmount(@PathVariable String accountNumber, @PathVariable double amount) {
		return bankCustomerService.withdrawAmount(accountNumber, amount);

	}
	           //Transfer Amount One Account to another Account
	@PostMapping("/transferAmount/{accountNumber1}/{accountNumber2}/{amount}") 
	public BankCustomerDetails transferAmount(@PathVariable String accountNumber1, @PathVariable String accountNumber2,
			@PathVariable double amount) {
		System.out.println(accountNumber1 + "  " + accountNumber2 + "  " + amount);
		return bankCustomerService.transferAmount(accountNumber1, accountNumber2, amount);

	}

	@GetMapping("/getCreditedDetails/{accountNumber}") //get Credited Details
	public List<CreditedDetails> getCreditedDetails(@PathVariable String accountNumber) {
		return bankCustomerService.getCreditedDetails(accountNumber);

	}

	@GetMapping("/getDebitedDetails/{accountNumber}")  //get DebitDetails
	public List<DebitDetails> getDebitedDetails(@PathVariable String accountNumber) {
		return bankCustomerService.getDebitedDetails(accountNumber);
	}

	@GetMapping("/getTransactions/{accountNumber}/{date}")  //get TransactionDetails through date
	public List<TransactionDetails> getTransactions(@PathVariable String accountNumber, @PathVariable String date) {
		return bankCustomerService.getAllTransactions(accountNumber, date);

	}
}
