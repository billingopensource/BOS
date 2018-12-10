package com.api.report.model;

public class ProductRatioOutput {

	private String productnm;
	private float productratio;
	private int productcnt;
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
	public String getProductnm() {
		return productnm;
	}
	public void setProductnm(String productnm) {
		this.productnm = productnm;
	}
	public float getProductratio() {
		return productratio;
	}
	public void setProductratio(float productratio) {
		this.productratio = productratio;
	}
	public int getProductcnt() {
		return productcnt;
	}
	public void setProductcnt(int productcnt) {
		this.productcnt = productcnt;
	}
	
	
	
}
