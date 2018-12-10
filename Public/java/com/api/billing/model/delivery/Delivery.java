package com.api.billing.model.delivery;

/**
 * @author P069556
 * 배송대상리스트 조회용
 */
public class Delivery 
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
	
	private String zipcode;
	private String customername;
	private String productname;
	private String phonenumber;
	private String addr;
	private String packageid;	
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
	public String getZipcode() {
		return zipcode;
	}
	public String getCustomername() {
		return customername;
	}
	public String getProductname() {
		return productname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public String getAddr() {
		return addr;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPackageid() {
		return packageid;
	}
	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}
	
	

	
}
