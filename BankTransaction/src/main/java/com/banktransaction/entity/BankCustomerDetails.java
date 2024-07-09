package com.banktransaction.entity;

import java.util.Date;


public class BankCustomerDetails {

	private int customerId;
	private String customerName;
	private String accountNumber;
	private String panNumber;
	private long phoneNumber;
	private double currentAmount;
	private double tillnowDepositamount;
	private double depositAmount;
	private double tillnowWithdrawamount;
	private double withdrawAmount;
	private String status;
	private Date date;
	
	//getter Setters
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	public double getTillnowDepositamount() {
		return tillnowDepositamount;
	}
	public void setTillnowDepositamount(double tillnowDepositamount) {
		this.tillnowDepositamount = tillnowDepositamount;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	public double getTillnowWithdrawamount() {
		return tillnowWithdrawamount;
	}
	public void setTillnowWithdrawamount(double tillnowWithdrawamount) {
		this.tillnowWithdrawamount = tillnowWithdrawamount;
	}
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankCustomer [customerId=" + customerId + ", customerName=" + customerName + ", accountNumber="
				+ accountNumber + ", panNumber=" + panNumber + ", phoneNumber=" + phoneNumber + ", currentAmount="
				+ currentAmount + ", tillnowDepositamount=" + tillnowDepositamount + ", depositAmount=" + depositAmount
				+ ", tillnowWithdrawamount=" + tillnowWithdrawamount + ", withdrawAmount=" + withdrawAmount
				+ ", Status=" + status + ", date=" + date + "]";
	}

}
