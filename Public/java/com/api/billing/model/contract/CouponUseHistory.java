package com.api.billing.model.contract;

public class CouponUseHistory {

	private int customerNumber;
	private String couponType;
	private String useDateTime;
	private String couponUseType;	
	private int useAmount;
	private String useHistory;
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
	public String getCouponType() {
		return couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
	public String getUseDateTime() {
		return useDateTime;
	}
	public void setUseDateTime(String useDateTime) {
		this.useDateTime = useDateTime;
	}
	public String getCouponUseType() {
		return couponUseType;
	}
	public void setCouponUseType(String couponUseType) {
		this.couponUseType = couponUseType;
	}
	public int getUseAmount() {
		return useAmount;
	}
	public void setUseAmount(int useAmount) {
		this.useAmount = useAmount;
	}
	public String getUseHistory() {
		return useHistory;
	}
	public void setUseHistory(String useHistory) {
		this.useHistory = useHistory;
	}
	
}
