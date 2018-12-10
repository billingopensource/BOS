package com.api.billing.invoice.model;

public class PaymentHistoryDetail {

	private String paymentdatetime;
	private String paymenttypecodename ;
	private String paymentmethodcodename ;
	private String paymentamount ;
	private String employeename ;
	private String reason ;
	private String etc ;
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
	
	public String getPaymentdatetime() {
		return paymentdatetime;
	}
	public void setPaymentdatetime(String paymentdatetime) {
		this.paymentdatetime = paymentdatetime;
	}
	public String getPaymenttypecodename() {
		return paymenttypecodename;
	}
	public void setPaymenttypecodename(String paymenttypecodename) {
		this.paymenttypecodename = paymenttypecodename;
	}
	public String getPaymentmethodcodename() {
		return paymentmethodcodename;
	}
	public void setPaymentmethodcodename(String paymentmethodcodename) {
		this.paymentmethodcodename = paymentmethodcodename;
	}
	public String getPaymentamount() {
		return paymentamount;
	}
	public void setPaymentamount(String paymentamount) {
		this.paymentamount = paymentamount;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
