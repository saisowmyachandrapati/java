package com.banktransaction.implementation;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.banktransaction.entity.BankCustomerDetails;
import com.banktransaction.entity.CreditedDetails;
import com.banktransaction.entity.DebitDetails;
import com.banktransaction.entity.TransactionDetails;
import com.banktransaction.repository.BankTransactionRepository;

@Repository
public class BankTransactionImplementation implements BankTransactionRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameter;

	@Override //Customer Registration
	public BankCustomerDetails saveCustomer(BankCustomerDetails customer) {
		String addCustomer = "Insert into bank_customer values (:id,:name,:accountid,:panId,"
				+ ":num,:balance,:tillnowD,:deposit,:tillnowW,:withdraw,:date,:status)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", customer.getCustomerId());
		param.addValue("name", customer.getCustomerName());
		param.addValue("accountid", customer.getAccountNumber());
		param.addValue("panId", customer.getPanNumber());
		param.addValue("num", customer.getPhoneNumber());
		param.addValue("balance", customer.getCurrentAmount());
		param.addValue("deposit", customer.getDepositAmount());
		param.addValue("withdraw", customer.getWithdrawAmount());
		param.addValue("tillnowD", customer.getTillnowDepositamount());
		param.addValue("tillnowW", customer.getTillnowWithdrawamount());
		param.addValue("date", new Date());
		param.addValue("status", "Successfully Registered");
		namedParameter.update(addCustomer, param);
		return customer;
	}

	@Override //getAllCustomer
	public List<BankCustomerDetails> getCustomer() {
		String getAll = "Select * from bank_customer";
		List<BankCustomerDetails> list = namedParameter.query(getAll, new BeanPropertyRowMapper<>(BankCustomerDetails.class));
		return list;
	}

	@Override  //getLastRecord
	public BankCustomerDetails getLatestRecord(String accountNumber) {
		String last = "SELECT * FROM bank_customer where account_number=:account_id ORDER BY customer_Id DESC LIMIT 1";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("account_id", accountNumber);
		BankCustomerDetails bc = namedParameter.queryForObject(last, param, new BeanPropertyRowMapper<>(BankCustomerDetails.class));
		System.out.println(bc);
		return bc;
	}

	
	public int maxId() {
		String last = "SELECT * FROM bank_customer ORDER BY customer_Id DESC LIMIT 1";
		MapSqlParameterSource param = new MapSqlParameterSource();
		BankCustomerDetails bc = namedParameter.queryForObject(last, param, new BeanPropertyRowMapper<>(BankCustomerDetails.class));
		int j = bc.getCustomerId();
		return j;
	}

	@Override
	public BankCustomerDetails addAmount(String accountNumber, double amount) {

		BankCustomerDetails data = getLatestRecord(accountNumber);
		String addCustomer = "Insert into bank_customer values (:id,:name,:accountid,:panId,:num,:balance,"
				+ ":tillnowD,:deposit,:tillnowW,:withdraw,:date,:status)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", maxId() + 1);
		param.addValue("name", data.getCustomerName());
		param.addValue("accountid", data.getAccountNumber());
		param.addValue("panId", data.getPanNumber());
		param.addValue("num", data.getPhoneNumber());
		param.addValue("balance", data.getCurrentAmount() + amount);
		param.addValue("deposit", amount);
		param.addValue("withdraw", 0);
		param.addValue("tillnowD", data.getTillnowDepositamount() + amount);
		param.addValue("tillnowW", data.getTillnowWithdrawamount());
		param.addValue("date", new Date());
		param.addValue("status", "Successfully Credited");
		namedParameter.update(addCustomer, param);
		return data;
	}
	@Override  //creditAmount
	public BankCustomerDetails withdrawAmount(String accountNumber, double amount) {

		BankCustomerDetails data = getLatestRecord(accountNumber);
		if (data.getCurrentAmount() > amount) {
			String addCustomer = "Insert into bank_customer values (:id,:name,:accountid,:panId,:num,:balance,"
					+ ":tillnowD,:deposit,:tillnowW,:withdraw,:date,:status)";
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("id", maxId() + 1);
			param.addValue("name", data.getCustomerName());
			param.addValue("accountid", data.getAccountNumber());
			param.addValue("panId", data.getPanNumber());
			param.addValue("num", data.getPhoneNumber());
			param.addValue("balance", data.getCurrentAmount() - amount);
			param.addValue("deposit", 0);
			param.addValue("withdraw", amount);
			param.addValue("tillnowD", data.getTillnowDepositamount());
			param.addValue("tillnowW", data.getTillnowWithdrawamount() + amount);
			param.addValue("date", new Date());
			param.addValue("status", "Successfully Debited");
			namedParameter.update(addCustomer, param);

		}
		return data;

	}

	@Override  //DebitAmount
	public BankCustomerDetails transferAmount(String accountNumber1, String accountNumber2, double amount) {
		BankCustomerDetails ac1 = getLatestRecord(accountNumber1);
		if (ac1.getCurrentAmount() < amount) {
			System.out.println("Check Once");
		} else {
			String addCustomer = "Insert into bank_customer values (:id,:name,:accountid,:panId,:num,"
					+ ":balance,:tillnowD,:deposit,:tillnowW,:withdraw,:date,:status)";
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("id", maxId() + 1);
			param.addValue("name", ac1.getCustomerName());
			param.addValue("accountid", ac1.getAccountNumber());
			param.addValue("panId", ac1.getPanNumber());
			param.addValue("num", ac1.getPhoneNumber());
			param.addValue("balance", ac1.getCurrentAmount() - amount);
			param.addValue("deposit", 0);
			param.addValue("withdraw", amount);
			param.addValue("tillnowD", ac1.getTillnowDepositamount());
			param.addValue("tillnowW", ac1.getTillnowWithdrawamount() + amount);
			param.addValue("date", new Date());
			param.addValue("status", "Successfully transfer: " + accountNumber2);
			namedParameter.update(addCustomer, param);

			BankCustomerDetails ac2 = getLatestRecord(accountNumber2);
			MapSqlParameterSource param1 = new MapSqlParameterSource();
			String add = "Insert into bank_customer values (:id,:name,:accountid,:panId,:num,:balance,"
					+ ":tillnowD,:deposit,:tillnowW,:withdraw,:date,:status)";
			param1.addValue("id", maxId() + 1);
			param1.addValue("name", ac2.getCustomerName());
			param1.addValue("accountid", ac2.getAccountNumber());
			param1.addValue("panId", ac2.getPanNumber());
			param1.addValue("num", ac2.getPhoneNumber());
			param1.addValue("balance", ac2.getCurrentAmount() + amount);
			param1.addValue("deposit", amount);
			param1.addValue("withdraw", 0);
			param1.addValue("tillnowD", ac2.getTillnowDepositamount() + amount);
			param1.addValue("tillnowW", ac2.getTillnowWithdrawamount());
			param1.addValue("date", new Date());
			param1.addValue("status", "Credited");
			namedParameter.update(add, param1);
		}
		return ac1;
	}

	@Override  //getCreditDetails of customer
	public List<CreditedDetails> getCreditedDetails(String accountNumber) {
		String details = "Select customer_Name, deposit_amount, date from bank_Customer where account_number=:acc and deposit_amount != 0";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("acc", accountNumber);
		List<CreditedDetails> list = namedParameter.query(details, param,
				new BeanPropertyRowMapper<>(CreditedDetails.class));
		return list;
	}

	@Override  //getDebitDetails of customer
	public List<DebitDetails> getDebitedDetails(String accountNumber) {
		String detail = "Select customer_Name, withdraw_amount, date from bank_Customer where account_number=:acc and withdraw_amount != 0";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("acc", accountNumber);
		List<DebitDetails> list = namedParameter.query(detail, param, new BeanPropertyRowMapper<>(DebitDetails.class));
		return list;
	}

	@Override    //GetAllTransactions
	public List<TransactionDetails> getAllTransactions(String accountNumber, String date) {
		String td = "Select customer_id, customer_Name, deposit_amount, withdraw_amount, date from bank_Customer where account_number=:acc and date=:date ";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("acc", accountNumber);
		param.addValue("date", date);
		List<TransactionDetails> deta = namedParameter.query(td, param,
				new BeanPropertyRowMapper<>(TransactionDetails.class));
		return deta;
	}

}
