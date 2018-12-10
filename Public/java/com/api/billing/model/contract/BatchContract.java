package com.api.billing.model.contract;

import com.api.billing.model.customer.CustomerType;
import com.api.billing.model.customer.SexType;

public class BatchContract {
	
	//Address
	private String addressId;
	private String zipcode;
	private String baseAddress;
	private String detailAddress;
	private String auditId;
	private String auditDateTime;
	//Customer
	private int customerNumber;
	private String customerName;
	private int providerNumber;
	private String sex;
	private String birthday;
	private String email;
	private String phoneNumber;	
	private String deliveryAddressId;
	private String customerType;
	private String createDate;
	private String currentDate;
	private String deleteDate;
  //PaymentInfoInsert
	private int paymentInformationNumber;
	private String paymentMethod;
	private String invoiceDeliveryType;
	private String invoiceEmail;
	//ContractInsert
	private String effectStartDateTime;
	private String effectEndDateTime;
	private String deliveryCycle;
	private int deliveryTimes;
	private String deliveryRemark;
	private String deliveryStartDatetime;
	private int deliveryTotalCount;
	private int deliveryRemainCount;
	private String invoiceCycle;
	//ContractProduct
	private String productId;
	private String productType;
	private String packageId; 
	private String packagePriceReferenceYn;
	private String packageVarietyYn;
	private String productQuantity;
	//ContractDiscount
	private String discountId;
	private String discountType;
	private String discountValue;
	private int discountOrder;
	private String contractDiscountEffectStartDateTime;
	private String contractDiscountEffectEndDateTime;
	
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
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
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
	public int getProviderNumber() {
		return providerNumber;
	}
	public void setProviderNumber(int providerNumber) {
		this.providerNumber = providerNumber;
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
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
	public int getPaymentInformationNumber() {
		return paymentInformationNumber;
	}
	public void setPaymentInformationNumber(int paymentInformationNumber) {
		this.paymentInformationNumber = paymentInformationNumber;
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
	public String getDeliveryCycle() {
		return deliveryCycle;
	}
	public void setDeliveryCycle(String deliveryCycle) {
		this.deliveryCycle = deliveryCycle;
	}
	public int getDeliveryTimes() {
		return deliveryTimes;
	}
	public void setDeliveryTimes(int deliveryTimes) {
		this.deliveryTimes = deliveryTimes;
	}
	public String getDeliveryRemark() {
		return deliveryRemark;
	}
	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}
	public String getDeliveryStartDatetime() {
		return deliveryStartDatetime;
	}
	public void setDeliveryStartDatetime(String deliveryStartDatetime) {
		this.deliveryStartDatetime = deliveryStartDatetime;
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
	public String getInvoiceCycle() {
		return invoiceCycle;
	}
	public void setInvoiceCycle(String invoiceCycle) {
		this.invoiceCycle = invoiceCycle;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getPackagePriceReferenceYn() {
		return packagePriceReferenceYn;
	}
	public void setPackagePriceReferenceYn(String packagePriceReferenceYn) {
		this.packagePriceReferenceYn = packagePriceReferenceYn;
	}
	public String getPackageVarietyYn() {
		return packageVarietyYn;
	}
	public void setPackageVarietyYn(String packageVarietyYn) {
		this.packageVarietyYn = packageVarietyYn;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getDiscountId() {
		return discountId;
	}
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getContractDiscountEffectStartDateTime() {
		return contractDiscountEffectStartDateTime;
	}
	public void setContractDiscountEffectStartDateTime(String contractDiscountEffectStartDateTime) {
		this.contractDiscountEffectStartDateTime = contractDiscountEffectStartDateTime;
	}
	public String getContractDiscountEffectEndDateTime() {
		return contractDiscountEffectEndDateTime;
	}
	public void setContractDiscountEffectEndDateTime(String contractDiscountEffectEndDateTime) {
		this.contractDiscountEffectEndDateTime = contractDiscountEffectEndDateTime;
	}
	public String getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
	}
	public int getDiscountOrder() {
		return discountOrder;
	}
	public void setDiscountOrder(int discountOrder) {
		this.discountOrder = discountOrder;
	}	
	
}
