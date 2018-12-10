package com.api.billing.invoice.model;

import com.api.model.Criteria;

public class InvoiceNameInput extends Criteria {

	private String customerName;
	private String phoneNumber;
	private String paymenttypeyn;
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
	public String getPaymenttypeyn() {
		return paymenttypeyn;
	}
	public void setPaymenttypeyn(String paymenttypeyn) {
		this.paymenttypeyn = paymenttypeyn;
	}
	

}
