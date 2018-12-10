package com.api.report.model;

public class InvoiceReportOutput {

	private String invYm;
	private int thismonthtotalInvoiceAmount;
	private int thismonthtotalCollectionBalanceAmount;
	private int todaytotalInvoiceAmount;
	private int todaytotalCollectionBalanceAmount;
	private int totalCollectionBalanceAmount;
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
	public String getInvYm() {
		return invYm;
	}
	public void setInvYm(String invYm) {
		this.invYm = invYm;
	}
	public int getThismonthtotalInvoiceAmount() {
		return thismonthtotalInvoiceAmount;
	}
	public void setThismonthtotalInvoiceAmount(int thismonthtotalInvoiceAmount) {
		this.thismonthtotalInvoiceAmount = thismonthtotalInvoiceAmount;
	}
	public int getThismonthtotalCollectionBalanceAmount() {
		return thismonthtotalCollectionBalanceAmount;
	}
	public void setThismonthtotalCollectionBalanceAmount(int thismonthtotalCollectionBalanceAmount) {
		this.thismonthtotalCollectionBalanceAmount = thismonthtotalCollectionBalanceAmount;
	}
	public int getTodaytotalInvoiceAmount() {
		return todaytotalInvoiceAmount;
	}
	public void setTodaytotalInvoiceAmount(int todaytotalInvoiceAmount) {
		this.todaytotalInvoiceAmount = todaytotalInvoiceAmount;
	}
	public int getTodaytotalCollectionBalanceAmount() {
		return todaytotalCollectionBalanceAmount;
	}
	public void setTodaytotalCollectionBalanceAmount(int todaytotalCollectionBalanceAmount) {
		this.todaytotalCollectionBalanceAmount = todaytotalCollectionBalanceAmount;
	}
	public int getTotalCollectionBalanceAmount() {
		return totalCollectionBalanceAmount;
	}
	public void setTotalCollectionBalanceAmount(int totalCollectionBalanceAmount) {
		this.totalCollectionBalanceAmount = totalCollectionBalanceAmount;
	}
	
	
	
}
