package com.api.billing.model.contract;

public class ContractInput {
	
	private int contractnumber;

	public int getContractnumber() {
		return contractnumber;
	}
	public void setContractnumber(int contractnumber) {
		this.contractnumber = contractnumber;
	}
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
}
