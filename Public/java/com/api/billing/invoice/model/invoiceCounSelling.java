package com.api.billing.invoice.model;

import com.api.model.Criteria;

public class invoiceCounSelling extends Criteria {

	private int invoicenumber;
	private int customernumber;
	private int connumber;
	private String invoicedate;
	private String memo;
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
	public int getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(int customernumber) {
		this.customernumber = customernumber;
	}
	public int getConnumber() {
		return connumber;
	}
	public void setConnumber(int connumber) {
		this.connumber = connumber;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
