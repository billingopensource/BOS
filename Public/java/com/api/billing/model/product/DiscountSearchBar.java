package com.api.billing.model.product;

public class DiscountSearchBar {

	String discountType;
	String discountName;
	String discountType2;
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
	
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getDiscountName() {
		return discountName;
	}
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	public String getDiscountType2() {
		// TODO Auto-generated method stub
		return discountType2;
	}
	public void setDiscountType2(String discountType2) {
		this.discountType2 = discountType2;
	}

}
