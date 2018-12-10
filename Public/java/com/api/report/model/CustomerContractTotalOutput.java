package com.api.report.model;

public class CustomerContractTotalOutput {
	
	private int total_customer_register;
	private int current_customer_register;
	private int total_contract_register;
	private int current_contract_register;
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
	public int getTotal_customer_register() {
		return total_customer_register;
	}
	public void setTotal_customer_register(int total_customer_register) {
		this.total_customer_register = total_customer_register;
	}
	public int getCurrent_customer_register() {
		return current_customer_register;
	}
	public void setCurrent_customer_register(int current_customer_register) {
		this.current_customer_register = current_customer_register;
	}
	public int getTotal_contract_register() {
		return total_contract_register;
	}
	public void setTotal_contract_register(int total_contract_register) {
		this.total_contract_register = total_contract_register;
	}
	public int getCurrent_contract_register() {
		return current_contract_register;
	}
	public void setCurrent_contract_register(int current_contract_register) {
		this.current_contract_register = current_contract_register;
	}
	
	

}
