package com.banktransaction.serviceimplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banktransaction.entity.BankCustomerDetails;
import com.banktransaction.entity.CreditedDetails;
import com.banktransaction.entity.DebitDetails;
import com.banktransaction.entity.TransactionDetails;
import com.banktransaction.repository.BankTransactionRepository;
import com.banktransaction.service.BankTransactionService;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	BankTransactionRepository bankCustomerRepository;

	@Override
	public List<BankCustomerDetails> getCustomer() {           
		return bankCustomerRepository.getCustomer();
	}

	@Override
	public BankCustomerDetails saveCustomer(BankCustomerDetails customer) {
		return bankCustomerRepository.saveCustomer(customer);
	}

	@Override
	public BankCustomerDetails addAmount(String accountNumber, double amount) {
		return bankCustomerRepository.addAmount(accountNumber, amount);
	}

	@Override
	public BankCustomerDetails getLatestRecord(String accountNumber) {
		return bankCustomerRepository.getLatestRecord(accountNumber);

	}

//	@Override
//	public int maxId() {
//		return bankCustomerRepository.maxId();
//	}

	@Override
	public BankCustomerDetails withdrawAmount(String accountNumber, double amount) {
		return bankCustomerRepository.withdrawAmount(accountNumber, amount);
	}

	@Override
	public BankCustomerDetails transferAmount(String accountNumber1, String accountNumber2, double amount) {
		return bankCustomerRepository.transferAmount(accountNumber1, accountNumber2, amount);
	}

	@Override
	public List<CreditedDetails> getCreditedDetails(String accountNumber) {
		return bankCustomerRepository.getCreditedDetails(accountNumber);
	}

	@Override
	public List<DebitDetails> getDebitedDetails(String accountNumber) {
		return bankCustomerRepository.getDebitedDetails(accountNumber);
	}

	@Override
	public List<TransactionDetails> getAllTransactions(String accountNumber, String date) {
		return bankCustomerRepository.getAllTransactions(accountNumber, date);
	}
}
