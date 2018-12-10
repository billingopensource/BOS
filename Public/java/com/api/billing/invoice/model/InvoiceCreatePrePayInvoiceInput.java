package com.api.billing.invoice.model;

import com.api.model.Criteria;

public class InvoiceCreatePrePayInvoiceInput extends Criteria {

	private int connumber;
	private String calfromDate;
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

	public int getConnumber() {
		return connumber;
	}

	public void setConnumber(int connumber) {
		this.connumber = connumber;
	}

	public String getCalfromDate() {
		return calfromDate;
	}

	public void setCalfromDate(String calfromDate) {
		this.calfromDate = calfromDate;
	}

}