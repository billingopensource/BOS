package com.api.billing.invoice.model;

public class InvoiceDetailCustomerInfo {
	
	private String customerName;
	private String phoneNumber;
	private String productName;
	private String productDescription;
	private String invoicedate;
	private String paymentdate;
	private String email;
	
	public InvoiceDetailCustomerInfo(){
		setCustomerName("");
		setPhoneNumber("");
		setProductName("");
		setProductDescription("");
		setInvoicedate("");
		setPaymentdate("");
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
