package com.api.billing.invoice.model;

public class InvoiceAdjustInput {

	private int    invoicenumber;
	private String invoicedate;
	private int    conNumber;
	private String invoiceClassificationCode;
	private String revenueItemCode;
	private int    adjustPossibleAmount;
	private int    adjustamt;
	private String adjustreasonmessage;
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
	
	public InvoiceAdjustInput(int invoicenumber
			                 ,String invoiceDate
			                 ,int    conNumber
			                 ,String invoiceClassificationCode
			                 ,String revenueItemCode
			                 ,int    adjustPossibleAmount
			                 ,int    adjustamt
			                 ,String adjustreasonmessage
			                 ) 
	{
		this.invoicenumber = invoicenumber;
		this.invoicedate   = invoiceDate;
		this.conNumber = conNumber;
		this.invoiceClassificationCode = invoiceClassificationCode;
		this.revenueItemCode = revenueItemCode;
		this.adjustPossibleAmount = adjustPossibleAmount;
		this.adjustamt = adjustamt;
		this.adjustreasonmessage = adjustreasonmessage;
	}
	
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

	public int getConNumber() {
		return conNumber;
	}
	public void setConNumber(int conNumber) {
		this.conNumber = conNumber;
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
	public int getAdjustamt() {
		return adjustamt;
	}
	public void setAdjustamt(int adjustamt) {
		this.adjustamt = adjustamt;
	}
	public String getAdjustreasonmessage() {
		return adjustreasonmessage;
	}
	public void setAdjustreasonmessage(String adjustreasonmessage) {
		this.adjustreasonmessage = adjustreasonmessage;
	}
	
	
	
	
}
