package com.api.billing.invoice.model;

public class InvoiceCalculation {

	private String paymenttype;
	private int invoicenumber;
	private String invoicedate;
	private String customername;
	private String productname;
	private int totalinvoiceamount;
	private int collectionbalanceamount;
	private int connumber;
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
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getTotalinvoiceamount() {
		return totalinvoiceamount;
	}
	public void setTotalinvoiceamount(int totalinvoiceamount) {
		this.totalinvoiceamount = totalinvoiceamount;
	}
	public int getCollectionbalanceamount() {
		return collectionbalanceamount;
	}
	public void setCollectionbalanceamount(int collectionbalanceamount) {
		this.collectionbalanceamount = collectionbalanceamount;
	}
	public int getConnumber() {
		return connumber;
	}
	public void setConnumber(int connumber) {
		this.connumber = connumber;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	
	
}
