package com.api.billing.invoice.model;

import com.api.model.Criteria;

public class PaymentPrePayInvoiceInput extends Criteria {

	private int invoicenumber;
	private int connumber;
	private String invoicedate;
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

	public int getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(int invoicenumber) {
		this.invoicenumber = invoicenumber;
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

}
