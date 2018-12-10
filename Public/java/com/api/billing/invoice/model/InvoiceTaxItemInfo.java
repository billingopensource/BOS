package com.api.billing.invoice.model;

public class InvoiceTaxItemInfo {

	private int invoiceItemAmount  ;
	private int vatAmount;
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
	public int getInvoiceItemAmount() {
		return invoiceItemAmount;
	}
	public void setInvoiceItemAmount(int invoiceItemAmount) {
		this.invoiceItemAmount = invoiceItemAmount;
	}
	public int getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(int vatAmount) {
		this.vatAmount = vatAmount;
	}
	
	
	
}
