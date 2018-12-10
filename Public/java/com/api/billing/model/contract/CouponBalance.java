package com.api.billing.model.contract;

public class CouponBalance {

	private int customerNumber;
	private String couponType;
	private int couponBalance;
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
	public int getCouponBalance() {
		return couponBalance;
	}
	public void setCouponBalance(int couponBalance) {
		this.couponBalance = couponBalance;
	}
	
}
