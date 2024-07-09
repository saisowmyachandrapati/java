package com.banktransaction.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.banktransaction.entity.BankCustomerDetails;
import com.banktransaction.entity.CreditedDetails;
import com.banktransaction.entity.DebitDetails;
import com.banktransaction.entity.TransactionDetails;


@Service
public interface BankTransactionService {
	
	public List<BankCustomerDetails> getCustomer(); 
	public BankCustomerDetails saveCustomer(BankCustomerDetails customer);
	public BankCustomerDetails addAmount(String accountNumber,double amount);
	public BankCustomerDetails getLatestRecord(String accountNumber);
	
	public BankCustomerDetails withdrawAmount(String accountNumber ,double amount);
	public BankCustomerDetails transferAmount(String accountNumber1,String accountNumber2,double amount);
	public List<CreditedDetails> getCreditedDetails(String accountNumber);
	public List<DebitDetails> getDebitedDetails(String accountNumber);
	public List<TransactionDetails> getAllTransactions(String accountNumber,String date);

}
