package com.api.billing.invoice.model;

public class InvoiceAdjust {
	
	
	private int invoiceNumber;
	private String invoiceClassificationCode;
	private String revenueItemCode;
	private String revenueItemCodnm;
	private int adjustPossibleAmount;
	private int invoiceItemAmount;
	private String taxYn;
	private String adjPossibleYn;
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
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceClassificationCode() {
		return invoiceClassificationCode;
	}
	public void setInvoiceClassificationCode(String invoiceClassificationCode) {
		this.invoiceClassificationCode = invoiceClassificationCode;
	}
	public String getRevenueItemCode() {
		return revenueItemCode;
	}
	public void setRevenueItemCode(String revenueItemCode) {
		this.revenueItemCode = revenueItemCode;
	}
	public int getAdjustPossibleAmount() {
		return adjustPossibleAmount;
	}
	public void setAdjustPossibleAmount(int adjustPossibleAmount) {
		this.adjustPossibleAmount = adjustPossibleAmount;
	}
	public int getInvoiceItemAmount() {
		return invoiceItemAmount;
	}
	public void setInvoiceItemAmount(int invoiceItemAmount) {
		this.invoiceItemAmount = invoiceItemAmount;
	}
	public String getTaxYn() {
		return taxYn;
	}
	public void setTaxYn(String taxYn) {
		this.taxYn = taxYn;
	}
	public String getAdjPossibleYn() {
		return adjPossibleYn;
	}
	public void setAdjPossibleYn(String adjPossibleYn) {
		this.adjPossibleYn = adjPossibleYn;
	}
	public String getRevenueItemCodnm() {
		return revenueItemCodnm;
	}
	public void setRevenueItemCodnm(String revenueItemCodnm) {
		this.revenueItemCodnm = revenueItemCodnm;
	}
	
	
	
	
}
