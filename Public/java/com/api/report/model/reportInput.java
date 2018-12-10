package com.api.report.model;

public class reportInput {

	private String calfromDate;

	/* ID mapping */
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

	/* ID mapping */
	public String getCalfromDate() {
		return calfromDate;
	}

	public void setCalfromDate(String calfromDate) {
		this.calfromDate = calfromDate;
	}
}
