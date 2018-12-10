package com.api.billing.model.customer;

import com.api.model.Criteria;

public class Customer extends Criteria {

	private int customerNumber;
	private String customerName;
	private String sex;
	private String birthday;
	private String email;
	private String phoneNumber;	
	private String addressId;
	private String deliveryAddressId;
	private String customerType;
	private String createDate;
	private String currentDate;
	private String deleteDate;
	private String auditId;
	private String auditDateTime;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getDeliveryAddressId() {
		return deliveryAddressId;
	}
	public void setDeliveryAddressId(String deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditDateTime() {
		return auditDateTime;
	}
	public void setAuditDateTime(String auditDateTime) {
		this.auditDateTime = auditDateTime;
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
