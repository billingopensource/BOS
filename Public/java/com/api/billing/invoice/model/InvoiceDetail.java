package com.api.billing.invoice.model;

public class InvoiceDetail {
	
	private int    invoiceNumber ;
	private String invoiceClassificationCode; 
	private String revenueItemCode;
	private int    invoiceItemAmount;
	private int    adjustamt;
	private int    collectionBalanceAmount;
	private int    paymentAmount;
	private int    conNumber;
	/*ID mapping*/
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
	/*ID mapping*/
	
	
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public int getConNumber() {
		return conNumber;
	}
	public void setConNumber(int conNumber) {
		this.conNumber = conNumber;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceClassificationCode() {
		return invoiceClassificationCode;
	}
	public void setInvoiceClassificationCode(String invoiceClassificationCode) {
		this.invoiceClassificationCode = invoiceClassificationCode;
	}
	public String getRevenueItemCode() {
		return revenueItemCode;
	}
	public void setRevenueItemCode(String revenueItemCode) {
		this.revenueItemCode = revenueItemCode;
	}
	public int getInvoiceItemAmount() {
		return invoiceItemAmount;
	}
	public void setInvoiceItemAmount(int invoiceItemAmount) {
		this.invoiceItemAmount = invoiceItemAmount;
	}

	public int getAdjustamt() {
		return adjustamt;
	}
	public void setAdjustamt(int adjustamt) {
		this.adjustamt = adjustamt;
	}
	public int getCollectionBalanceAmount() {
		return collectionBalanceAmount;
	}
	public void setCollectionBalanceAmount(int collectionBalanceAmount) {
		this.collectionBalanceAmount = collectionBalanceAmount;
	}
	
	
}
