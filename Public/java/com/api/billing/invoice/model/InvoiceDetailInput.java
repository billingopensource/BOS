package com.api.billing.invoice.model;

import com.api.model.Criteria;

public class InvoiceDetailInput extends Criteria {
	private int InvoiceNumber;
	private String InvoiceDate;
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
	
	public InvoiceDetailInput() {
		
	}
	
	public InvoiceDetailInput(int invoiceNumber, String invoiceDate, int conNumber) {
		super();
		InvoiceNumber = invoiceNumber;
		InvoiceDate = invoiceDate;
		this.conNumber = conNumber;
	}
	public int getInvoiceNumber() {
		return InvoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}
	public String getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	public int getConNumber() {
		return conNumber;
	}
	public void setConNumber(int conNumber) {
		this.conNumber = conNumber;
	}
	
}
