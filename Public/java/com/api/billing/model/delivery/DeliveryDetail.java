package com.api.billing.model.delivery;

/**
 * @author P069556
 * 배송대상리스트 Insert용 
 * 1) 일괄결제(선납고객)의 경우 0원 invoice 생성시 배송대상 데이터 insert 를 위한 클래스
 * 2) 정기결제의 경우 매월 수납처리 완료시 배송대상 데이터 insert 를 위한 클래스
 */

public class DeliveryDetail 
{
	private int    deliveryNumber;
	private int    conNumber;
	private int    customerNumber;
	private int    providerNumber;
	private int    invoiceNumber;	
	private String invoiceDate;	
	private String deliveryDate;
	private String deliveryState;
	private String deliverydatetime;
	private String deliveryRemark;
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
	public int getDeliveryNumber() {
		return deliveryNumber;
	}
	public int getConNumber() {
		return conNumber;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public int getProviderNumber() {
		return providerNumber;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public String getDeliverydatetime() {
		return deliverydatetime;
	}
	public String getDeliveryRemark() {
		return deliveryRemark;
	}
	public void setDeliveryNumber(int deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public void setConNumber(int conNumber) {
		this.conNumber = conNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public void setProviderNumber(int providerNumber) {
		this.providerNumber = providerNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	public void setDeliverydatetime(String deliverydatetime) {
		this.deliverydatetime = deliverydatetime;
	}
	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}
	
	

}
