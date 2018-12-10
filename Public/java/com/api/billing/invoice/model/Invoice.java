package com.api.billing.invoice.model;

public class Invoice {

	private int    invoicenumber;
	private String paymenttype; /* 20181128 수정*/
	private String invoiceDate;
	private String customerName ;
	private String productName ;
	private String invoicecycle;
	private int paymentAmount ;
	private String paymentDateTime ;
	private int totalInvoiceAmount ;
	private int collectionBalanceAmount ;
	private String paymentstatecodename;
	private String paymentdate;
	private String errorReason ;
	private int conNumber;
	private String email;
	private String phonenumber;
	private int customernumber ;
	private int adjustamount;
	private int offerpayamount;
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
	
	public int getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(int invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getInvoicecycle() {
		return invoicecycle;
	}
	public void setInvoicecycle(String invoicecycle) {
		this.invoicecycle = invoicecycle;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentDateTime() {
		return paymentDateTime;
	}
	public void setPaymentDateTime(String paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
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
	public String getPaymentstatecodename() {
		return paymentstatecodename;
	}
	public void setPaymentstatecodename(String paymentstatecodename) {
		this.paymentstatecodename = paymentstatecodename;
	}
	public String getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}
	public String getErrorReason() {
		return errorReason;
	}
	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}
	public int getConNumber() {
		return conNumber;
	}
	public void setConNumber(int conNumber) {
		this.conNumber = conNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(int customernumber) {
		this.customernumber = customernumber;
	}
	public int getAdjustamount() {
		return adjustamount;
	}
	public void setAdjustamount(int adjustamount) {
		this.adjustamount = adjustamount;
	}
	public int getOfferpayamount() {
		return offerpayamount;
	}
	public void setOfferpayamount(int offerpayamount) {
		this.offerpayamount = offerpayamount;
	}
	public String getPaymenttype() {  /* 20181128 수정*/
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {  /* 20181128 수정*/
		this.paymenttype = paymenttype;
	}
}
