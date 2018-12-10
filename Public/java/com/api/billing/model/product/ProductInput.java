package com.api.billing.model.product;

import com.api.model.Criteria;

public class ProductInput extends Criteria 
{
	private String productId;
	private String productType;
	private String productName;
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
	public String getProductType() {
		return productType;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductId(String productId) {
		return productId;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
