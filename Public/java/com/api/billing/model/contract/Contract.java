package com.api.billing.model.contract;

public class Contract {

	private int conNumber;
	private int customerNumber;
	private int paymentinformationnumber;
	private String contractstate;
	private String effectstartdatetime;
	private String effectenddatetime;
	private String terminationreason;
	private String suspenddatetime;
	private String subscribedatetime;
	private String suspendreason;
	private String recurringdeliveryyn;
	private String deliverycycle;
	private int deliverytimes;
	private String deliveryremark;
	private String deliverystartdatetime;
	private String recurringInvoiceYn;
	private String invoicecycle;
	private String lastinvoicedatetime;
	private String nextinvoicedatetime;
	private String lastchangedatetime;
	private String auditid;
	private String auditdatetime;
	
	private int deliveryTotalCount;
	private int deliveryRemainCount;
	
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
	
	public int getConNumber() {
		return conNumber;
	}
	public void setConNumber(int conNumber) {
		this.conNumber = conNumber;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getPaymentinformationnumber() {
		return paymentinformationnumber;
	}
	public void setPaymentinformationnumber(int paymentinformationnumber) {
		this.paymentinformationnumber = paymentinformationnumber;
	}
	public String getContractstate() {
		return contractstate;
	}
	public void setContractstate(String contractstate) {
		this.contractstate = contractstate;
	}
	public String getEffectstartdatetime() {
		return effectstartdatetime;
	}
	public void setEffectstartdatetime(String effectstartdatetime) {
		this.effectstartdatetime = effectstartdatetime;
	}
	public String getEffectenddatetime() {
		return effectenddatetime;
	}
	public void setEffectenddatetime(String effectenddatetime) {
		this.effectenddatetime = effectenddatetime;
	}
	public String getTerminationreason() {
		return terminationreason;
	}
	public void setTerminationreason(String terminationreason) {
		this.terminationreason = terminationreason;
	}
	public String getSuspenddatetime() {
		return suspenddatetime;
	}
	public void setSuspenddatetime(String suspenddatetime) {
		this.suspenddatetime = suspenddatetime;
	}
	public String getSuspendreason() {
		return suspendreason;
	}
	public void setSuspendreason(String suspendreason) {
		this.suspendreason = suspendreason;
	}
	public String getRecurringdeliveryyn() {
		return recurringdeliveryyn;
	}
	public void setRecurringdeliveryyn(String recurringdeliveryyn) {
		this.recurringdeliveryyn = recurringdeliveryyn;
	}
	public String getDeliverycycle() {
		return deliverycycle;
	}
	public void setDeliverycycle(String deliverycycle) {
		this.deliverycycle = deliverycycle;
	}
	public int getDeliverytimes() {
		return deliverytimes;
	}
	public void setDeliverytimes(int deliverytimes) {
		this.deliverytimes = deliverytimes;
	}
	public String getDeliveryremark() {
		return deliveryremark;
	}
	public void setDeliveryremark(String deliveryremark) {
		this.deliveryremark = deliveryremark;
	}
	public String getDeliverystartdatetime() {
		return deliverystartdatetime;
	}
	public void setDeliverystartdatetime(String deliverystartdatetime) {
		this.deliverystartdatetime = deliverystartdatetime;
	}
	
	public String getRecurringInvoiceYn() {
		return recurringInvoiceYn;
	}
	public void setRecurringInvoiceYn(String recurringInvoiceYn) {
		this.recurringInvoiceYn = recurringInvoiceYn;
	}
	public String getInvoicecycle() {
		return invoicecycle;
	}
	public void setInvoicecycle(String invoicecycle) {
		this.invoicecycle = invoicecycle;
	}
	public String getLastinvoicedatetime() {
		return lastinvoicedatetime;
	}
	public void setLastinvoicedatetime(String lastinvoicedatetime) {
		this.lastinvoicedatetime = lastinvoicedatetime;
	}
	public String getNextinvoicedatetime() {
		return nextinvoicedatetime;
	}
	public void setNextinvoicedatetime(String nextinvoicedatetime) {
		this.nextinvoicedatetime = nextinvoicedatetime;
	}
	public String getLastchangedatetime() {
		return lastchangedatetime;
	}
	public void setLastchangedatetime(String lastchangedatetime) {
		this.lastchangedatetime = lastchangedatetime;
	}
	public String getAuditid() {
		return auditid;
	}
	public void setAuditid(String auditid) {
		this.auditid = auditid;
	}
	public String getAuditdatetime() {
		return auditdatetime;
	}
	public void setAuditdatetime(String auditdatetime) {
		this.auditdatetime = auditdatetime;
	}
	
	public int getDeliveryTotalCount() {
		return deliveryTotalCount;
	}
	public void setDeliveryTotalCount(int deliveryTotalCount) {
		this.deliveryTotalCount = deliveryTotalCount;
	}
	public int getDeliveryRemainCount() {
		return deliveryRemainCount;
	}
	public void setDeliveryRemainCount(int deliveryRemainCount) {
		this.deliveryRemainCount = deliveryRemainCount;
	}
	public String getSubscribedatetime() {
		return subscribedatetime;
	}
	public void setSubscribedatetime(String subscribedatetime) {
		this.subscribedatetime = subscribedatetime;
	}
	
	
	
}
