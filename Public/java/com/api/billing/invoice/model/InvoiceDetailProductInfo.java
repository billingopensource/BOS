package com.api.billing.invoice.model;

public class InvoiceDetailProductInfo {
 
 private String customerName;
 private String mainProductId;
 private String mainProductName;
 private String mainProductType;
 private String compositionProductId;
 private String compositionProductName;
 private String compositionPriceAmount;
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
 public InvoiceDetailProductInfo(){
  setCustomerName("");
  setMainProductId("");
  setMainProductName("");
  setMainProductType("");
  setCompositionProductId("");
  setCompositionProductName("");
  setCompositionPriceAmount("");
  
 }
 
 public String getCustomerName() {
  return customerName;
 }
 public void setCustomerName(String customerName) {
  this.customerName = customerName;
 }
 public String getMainProductId() {
  return mainProductId;
 }
 public void setMainProductId(String mainProductId) {
  this.mainProductId = mainProductId;
 }
 public String getMainProductName() {
  return mainProductName;
 }
 public void setMainProductName(String mainProductName) {
  this.mainProductName = mainProductName;
 }
 public String getMainProductType() {
  return mainProductType;
 }
 public void setMainProductType(String mainProductType) {
  this.mainProductType = mainProductType;
 }
 public String getCompositionProductId() {
  return compositionProductId;
 }
 public void setCompositionProductId(String compositionProductId) {
  this.compositionProductId = compositionProductId;
 }
 public String getCompositionProductName() {
  return compositionProductName;
 }
 public void setCompositionProductName(String compositionProductName) {
  this.compositionProductName = compositionProductName;
 }
 public String getCompositionPriceAmount() {
  return compositionPriceAmount;
 }
 public void setCompositionPriceAmount(String compositionPriceAmount) {
  this.compositionPriceAmount = compositionPriceAmount;
 }
 
}