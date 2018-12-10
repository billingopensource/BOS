package com.api.billing.model.contract;

public class ContractListResult {

	private int customerNumber;
	private int conNumber;
	private String contractState;
	private String productName;
	private String effectStartDateTime;
	private String effectEndDateTime;
	private String duration;
	private String priceAmount;
	private String recurringInvoiceYn;
	private String deliveryCycle;
	private String invoiceCycle;
	
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
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getConNumber() {
		return conNumber;
	}
	public void setConNumber(int conNumber) {
		this.conNumber = conNumber;
	}
	public String getContractState() {
		return contractState;
	}
	public void setContractState(String contractState) {
		this.contractState = contractState;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getEffectStartDateTime() {
		return effectStartDateTime;
	}
	public void setEffectStartDateTime(String effectStartDateTime) {
		this.effectStartDateTime = effectStartDateTime;
	}
	public String getEffectEndDateTime() {
		return effectEndDateTime;
	}
	public void setEffectEndDateTime(String effectEndDateTime) {
		this.effectEndDateTime = effectEndDateTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(String priceAmount) {
		this.priceAmount = priceAmount;
	}
	public String getRecurringInvoiceYn() {
		return recurringInvoiceYn;
	}
	public void setRecurringInvoiceYn(String recurringInvoiceYn) {
		this.recurringInvoiceYn = recurringInvoiceYn;
	}
	public String getDeliveryCycle() {
		return deliveryCycle;
	}
	public void setDeliveryCycle(String deliveryCycle) {
		this.deliveryCycle = deliveryCycle;
	}
	public String getInvoiceCycle() {
		return invoiceCycle;
	}
	public void setInvoiceCycle(String invoiceCycle) {
		this.invoiceCycle = invoiceCycle;
	}
		
}
