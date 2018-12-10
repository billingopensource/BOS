package com.api.billing.model.customer;

public class CounsellingHistory {

	private int customerNumber;
	private String counsellingDate;
	private String counsellingTime;
	private String category;
	private String inboundPath;
	private String memo;
	private String createUser;
	private String auditId;
	private String auditDateTime;
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
	public String getCounsellingDate() {
		return counsellingDate;
	}
	public void setCounsellingDate(String counsellingDate) {
		this.counsellingDate = counsellingDate;
	}
	public String getCounsellingTime() {
		return counsellingTime;
	}
	public void setCounsellingTime(String counsellingTime) {
		this.counsellingTime = counsellingTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInboundPath() {
		return inboundPath;
	}
	public void setInboundPath(String inboundPath) {
		this.inboundPath = inboundPath;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditDateTime() {
		return auditDateTime;
	}
	public void setAuditDateTime(String auditDateTime) {
		this.auditDateTime = auditDateTime;
	}

}
