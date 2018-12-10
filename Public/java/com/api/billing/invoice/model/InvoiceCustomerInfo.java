package com.api.billing.invoice.model;

public class InvoiceCustomerInfo {
	/* 20180909 수정 */

	private String customerName;
	private int contractCount;
	private int totalInvoiceAmount;
	private int collectionBalanceAmount;
	/* ID mapping */
	private String username;
	private int providernumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProvidernumber() {
		return providernumber;
	}

	public void setProvidernumber(int providernumber) {
		this.providernumber = providernumber;
	}

	/* ID mapping */
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getContractCount() {
		return contractCount;
	}

	public void setContractCount(int contractCount) {
		this.contractCount = contractCount;
	}

	public int getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}

	public void setTotalInvoiceAmount(int totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}

	public int getCollectionBalanceAmount() {
		return collectionBalanceAmount;
	}

	public void setCollectionBalanceAmount(int collectionBalanceAmount) {
		this.collectionBalanceAmount = collectionBalanceAmount;
	}

}