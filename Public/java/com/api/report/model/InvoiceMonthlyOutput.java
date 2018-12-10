package com.api.report.model;

public class InvoiceMonthlyOutput {

	private String salemonthym;
	private int salemonthamt;
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
	public String getSalemonthym() {
		return salemonthym;
	}
	public void setSalemonthym(String salemonthym) {
		this.salemonthym = salemonthym;
	}
	public int getSalemonthamt() {
		return salemonthamt;
	}
	public void setSalemonthamt(int salemonthamt) {
		this.salemonthamt = salemonthamt;
	}
	
	
	
}
