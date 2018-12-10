package com.api.billing.invoice.model;

public class PaymentHistoryInput {

	private int invoicenumber;
	private String invoicedate;
	private int connumber;
	private int paymentamt;
	private String paymenttypecode;
	private String cardcorporationcode;
	private String cardapprovenumber;
	private String paymentownername;
	private String memo;
	private String channelgubun;
	private String itemname;
	private String vatamount;
	private String quantity;
	private String tid;
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
	public PaymentHistoryInput() {
		
	}
	
	
	public PaymentHistoryInput(int invoicenumber, String invoicedate, int connumber, int paymentamt,
			String paymenttypecode) {
		super();
		this.invoicenumber = invoicenumber;
		this.invoicedate = invoicedate;
		this.connumber = connumber;
		this.paymentamt = paymentamt;
		this.paymenttypecode = paymenttypecode;
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
	public int getConnumber() {
		return connumber;
	}
	public void setConnumber(int connumber) {
		this.connumber = connumber;
	}
	public int getPaymentamt() {
		return paymentamt;
	}
	public void setPaymentamt(int paymentamt) {
		this.paymentamt = paymentamt;
	}
	public String getPaymenttypecode() {
		return paymenttypecode;
	}
	public void setPaymenttypecode(String paymenttypecode) {
		this.paymenttypecode = paymenttypecode;
	}
	public String getCardcorporationcode() {
		return cardcorporationcode;
	}
	public void setCardcorporationcode(String cardcorporationcode) {
		this.cardcorporationcode = cardcorporationcode;
	}
	public String getCardapprovenumber() {
		return cardapprovenumber;
	}
	public void setCardapprovenumber(String cardapprovenumber) {
		this.cardapprovenumber = cardapprovenumber;
	}
	public String getPaymentownername() {
		return paymentownername;
	}
	public void setPaymentownername(String paymentownername) {
		this.paymentownername = paymentownername;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}


	public String getChannelgubun() {
		return channelgubun;
	}


	public void setChannelgubun(String channelgubun) {
		this.channelgubun = channelgubun;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public String getVatamount() {
		return vatamount;
	}


	public void setVatamount(String vatamount) {
		this.vatamount = vatamount;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}

	
}
