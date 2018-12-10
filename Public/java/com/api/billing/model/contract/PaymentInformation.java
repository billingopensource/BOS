package com.api.billing.model.contract;

public class PaymentInformation {

	private String customerNumber;
	private String conNumber;
	private String paymentInformationNumber;
	private String paymentMethod;
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
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getConNumber() {
		return conNumber;
	}
	public void setConNumber(String conNumber) {
		this.conNumber = conNumber;
	}
	public String getPaymentInformationNumber() {
		return paymentInformationNumber;
	}
	public void setPaymentInformationNumber(String paymentInformationNumber) {
		this.paymentInformationNumber = paymentInformationNumber;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
