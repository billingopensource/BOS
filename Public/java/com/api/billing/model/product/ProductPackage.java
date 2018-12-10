package com.api.billing.model.product;

public class ProductPackage 
{
	private String packageId;	
	private String mainProductId;
	private String packageName;
	private String compositionProductId;
	private String compositionproductName;
	private String effectStartDateTime;
	private String effectEndDateTime;
	private String lastHistoryYn;
	private int providerNumber;
	private String priceamount;
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
	
	public String getPackageId() {
		return packageId;
	}
	
	public String getMainProductId() {
		return mainProductId;
	}
	public String getCompositionProductId() {
		return compositionProductId;
	}
	public String getEffectStartDateTime() {
		return effectStartDateTime;
	}
	public String getEffectEndDateTime() {
		return effectEndDateTime;
	}
	public String getLastHistoryYn() {
		return lastHistoryYn;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public void setMainProductId(String mainProductId) {
		this.mainProductId = mainProductId;
	}
	public void setCompositionProductId(String compositionProductId) {
		this.compositionProductId = compositionProductId;
	}
	public void setEffectStartDateTime(String effectStartDateTime) {
		this.effectStartDateTime = effectStartDateTime;
	}
	public void setEffectEndDateTime(String effectEndDateTime) {
		this.effectEndDateTime = effectEndDateTime;
	}
	public void setLastHistoryYn(String lastHistoryYn) {
		this.lastHistoryYn = lastHistoryYn;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getCompositionproductName() {
		return compositionproductName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setCompositionproductName(String compositionproductName) {
		this.compositionproductName = compositionproductName;
	}

	public int getProviderNumber() {
		return providerNumber;
	}

	public void setProviderNumber(int providerNumber) {
		this.providerNumber = providerNumber;
	}

	public String getPriceamount() {
		return priceamount;
	}

	public void setPriceamount(String priceamount) {
		this.priceamount = priceamount;
	}


	
	

}
