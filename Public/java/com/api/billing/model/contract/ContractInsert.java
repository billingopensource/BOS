package com.api.billing.model.contract;


public class ContractInsert {

	private int conNumber;
	private int customerNumber;

	
	private String contractstate;
	private String subscribeDateTime;
	private String effectStartDateTime;
	private String effectEndDateTime;
	private String terminationreason;
	private String suspenddatetime;
	private String suspendreason;
	private String recurringdeliveryyn;
	private String deliveryCycle;
	private int deliveryTimes;
	private String deliveryRemark;
	private String deliveryStartDatetime;
	private String recurringInvoiceYn;
	private String invoiceCycle;
	private String lastinvoicedatetime;
	private String nextinvoicedatetime;
	private String lastchangedatetime;
	private String auditid;
	private String auditdatetime;
	private String productQuantity;
	
	private String packageYn;
	private String packagePriceReferenceYn;
	private String packageVarietyYn;
	private String packageId; 
	private String productId;
	private String productType;
	
//	private Discount dd[];
	
	private String discountId;
	private String discountType;
	private String discountValue;
	
	private int deliveryTotalCount;
	private int deliveryRemainCount;
	
	private int duration;
	
	private int discountOrder;
	private int priceAmount;
	
	//paymentInsert 추가
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

	public String getContractstate() {
		return contractstate;
	}
	public void setContractstate(String contractstate) {
		this.contractstate = contractstate;
	}
	
	public String getSubscribeDateTime() {
		return subscribeDateTime;
	}
	public void setSubscribeDateTime(String subscribeDateTime) {
		this.subscribeDateTime = subscribeDateTime;
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
	
	
	public int getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(int priceAmount) {
		this.priceAmount = priceAmount;
	}
	public String getRecurringInvoiceYn() {
		return recurringInvoiceYn;
	}
	public void setRecurringInvoiceYn(String recurringInvoiceYn) {
		this.recurringInvoiceYn = recurringInvoiceYn;
	}
	public String getInvoiceCycle() {
		return invoiceCycle;
	}
	public void setInvoiceCycle(String invoiceCycle) {
		this.invoiceCycle = invoiceCycle;
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
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
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
	public String getDiscountId() {
		return discountId;
	}
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	public String getPackageYn() {
		return packageYn;
	}
	public void setPackageYn(String packageYn) {
		this.packageYn = packageYn;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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
	public int getDiscountOrder() {
		return discountOrder;
	}
	public void setDiscountOrder(int discountOrder) {
		this.discountOrder = discountOrder;
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
