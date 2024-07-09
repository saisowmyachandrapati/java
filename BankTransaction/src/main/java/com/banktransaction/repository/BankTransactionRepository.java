package com.banktransaction.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.banktransaction.entity.BankCustomerDetails;
import com.banktransaction.entity.CreditedDetails;
import com.banktransaction.entity.DebitDetails;
import com.banktransaction.entity.TransactionDetails;


@Repository
public interface BankTransactionRepository {
	
	public BankCustomerDetails addAmount(String accountNumber ,double amount);
	public List<BankCustomerDetails> getCustomer(); 
	public BankCustomerDetails saveCustomer(BankCustomerDetails customer);
	public BankCustomerDetails getLatestRecord(String accountNumber);
//	public int maxId();
	public BankCustomerDetails withdrawAmount(String accountNumber ,double amount);
	public BankCustomerDetails transferAmount(String accountNumber1,String accountNumber2,double amount);
	public List<CreditedDetails> getCreditedDetails(String accountNumber);
	public List<DebitDetails> getDebitedDetails(String accountNumber);
	public List<TransactionDetails> getAllTransactions(String accountNumber,String date);

}
