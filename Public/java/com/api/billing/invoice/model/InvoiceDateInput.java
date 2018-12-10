package com.api.billing.invoice.model;

import com.api.billing.login.model.User;
import com.api.model.Criteria;

public class InvoiceDateInput extends Criteria {

	private String fromDate;
	private String toDate;
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
	
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getPaymenttypeyn() {
		return paymenttypeyn;
	}
	public void setPaymenttypeyn(String paymenttypeyn) {
		this.paymenttypeyn = paymenttypeyn;
	}

	
}
