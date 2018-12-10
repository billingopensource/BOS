package com.api.billing.invoice.model;

public class invoiceCounSellingResult {
	
	private int customernumber;
	private String counsellingdate;
	private String counsellingtime;
	private String category;
	private String inboundpath;
	private String memo;
	private String createuser;
	private int invoicenumber;
	private String invoicedate;
	private String productname;
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
	
	public int getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(int customernumber) {
		this.customernumber = customernumber;
	}
	public String getCounsellingdate() {
		return counsellingdate;
	}
	public void setCounsellingdate(String counsellingdate) {
		this.counsellingdate = counsellingdate;
	}
	public String getCounsellingtime() {
		return counsellingtime;
	}
	public void setCounsellingtime(String counsellingtime) {
		this.counsellingtime = counsellingtime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInboundpath() {
		return inboundpath;
	}
	public void setInboundpath(String inboundpath) {
		this.inboundpath = inboundpath;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public int getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(int invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	
}
