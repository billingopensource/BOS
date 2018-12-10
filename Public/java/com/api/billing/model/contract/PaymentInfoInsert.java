package com.api.billing.model.contract;

public class PaymentInfoInsert {

	private int customerNumber;
	private String paymentMethod;
	private String deliveryAddressId;
	private String invoiceDeliveryType;
	private String invoiceEmail;
	private String addressId;
	private int paymentInformationNumber;
	private String zipcode;
	private String baseAddress;
	private String detailAddress;
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
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getDeliveryAddressId() {
		return deliveryAddressId;
	}
	public void setDeliveryAddressId(String deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}
	public String getInvoiceDeliveryType() {
		return invoiceDeliveryType;
	}
	public void setInvoiceDeliveryType(String invoiceDeliveryType) {
		this.invoiceDeliveryType = invoiceDeliveryType;
	}
	public String getInvoiceEmail() {
		return invoiceEmail;
	}
	public void setInvoiceEmail(String invoiceEmail) {
		this.invoiceEmail = invoiceEmail;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public int getPaymentInformationNumber() {
		return paymentInformationNumber;
	}
	public void setPaymentInformationNumber(int paymentInformationNumber) {
		this.paymentInformationNumber = paymentInformationNumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getBaseAddress() {
		return baseAddress;
	}
	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	
	
}
