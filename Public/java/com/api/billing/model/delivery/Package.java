package com.api.billing.model.delivery;

public class Package 
{
	private String compositionProductId;
	private String compositionProductName;
	private String stdt;
	private String eddt;
	private int priceAmount;
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
	public String getCompositionProductId() {
		return compositionProductId;
	}
	public String getCompositionProductName() {
		return compositionProductName;
	}
	public int getPriceAmount() {
		return priceAmount;
	}
	public void setCompositionProductId(String compositionProductId) {
		this.compositionProductId = compositionProductId;
	}
	public void setCompositionProductName(String compositionProductName) {
		this.compositionProductName = compositionProductName;
	}
	public void setPriceAmount(int priceAmount) {
		this.priceAmount = priceAmount;
	}
	public String getStdt() {
		return stdt;
	}
	public String getEddt() {
		return eddt;
	}
	public void setStdt(String stdt) {
		this.stdt = stdt;
	}
	public void setEddt(String eddt) {
		this.eddt = eddt;
	}	
	
	

}
