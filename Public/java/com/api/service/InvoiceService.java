package com.api.service;

import java.util.List;

import com.api.billing.invoice.model.Invoice;
import com.api.billing.invoice.model.InvoiceAdjust;
import com.api.billing.invoice.model.InvoiceAdjustInput;
import com.api.billing.invoice.model.InvoiceCalculation;
import com.api.billing.invoice.model.InvoiceCalculationInput;
import com.api.billing.invoice.model.InvoiceDateInput;
import com.api.billing.invoice.model.InvoiceDetail;
import com.api.billing.invoice.model.InvoiceDetailCustomerInfo;
import com.api.billing.invoice.model.InvoiceDetailInput;
import com.api.billing.invoice.model.InvoiceDetailProductInfo;
import com.api.billing.invoice.model.InvoiceNameInput;
import com.api.billing.invoice.model.InvoiceTaxItemInfo;
import com.api.billing.invoice.model.PaymentHistoryDetail;
import com.api.billing.invoice.model.PaymentHistoryInput;
import com.api.billing.invoice.model.invoiceCounSelling;
import com.api.billing.invoice.model.invoiceCounSellingResult;
import com.api.billing.invoice.model.InvoiceCustomerInfo;
import com.api.billing.invoice.model.InvoiceCreatePrePayInvoiceInput;
import com.api.billing.invoice.model.PaymentPrePayInvoiceInput;
import com.api.model.Criteria;

public interface InvoiceService {
	
	/*pg payment */
	int insertPgpaymentlist(PaymentHistoryInput input);
	int selectPgpaymentlist(String input);
	
	List<InvoiceAdjust> getInvoiceAdjust(InvoiceDetailInput idi);
	List<InvoiceDetail> getInvoiceDetail(InvoiceDetailInput idi);
	InvoiceTaxItemInfo getInvoiceTaxItemAmount(InvoiceDetailInput idi);
	List<Invoice> getInvoiceByDate(InvoiceDateInput idi);
	InvoiceDetailCustomerInfo getInvoiceDetailCustomerInfo(InvoiceDetailInput idi);
	List<InvoiceDetailProductInfo> getInvoiceDetailProductInfo(InvoiceDetailInput idi);
	List<Invoice> getInvoiceByName(InvoiceNameInput idi);
	List<PaymentHistoryDetail> getPaymentHistory(InvoiceDetailInput idi);
	InvoiceCustomerInfo getInvoiceCustomerInfoByName(InvoiceDetailInput idi); /* 20180909 수정 */
	
	/*invoice counselling*/
	List<invoiceCounSellingResult> getCounsellingData(invoiceCounSelling idi);
	int getCounsellingTotalCount(invoiceCounSelling idi);
	int insertCounsellingHistory(invoiceCounSelling idi);
	

	 /*invoice calculation*/
	  int setInvoiceCalculation(InvoiceCalculationInput calfromDate);
	  int setInvoiceCalculationDiscountRate(InvoiceCalculationInput calfromDate);
	  int setInvoiceCalculationDiscountAmount(InvoiceCalculationInput calfromDate);
	  int setInvoiceCalculationDiscountOneTimeFee(InvoiceCalculationInput calfromDate);
	  /* int setInvoiceCalculationGeneralTax(String calfromDate);
	  int setInvoiceCalculationDiscountTax(String calfromDate); 20180911 수정 */ 
	  int setInvoiceDetail(InvoiceCalculationInput calfromDate);
	  int updateInvoiceDetail(InvoiceCalculationInput calfromDate);
	  int updateInvoiceCalculation(InvoiceCalculationInput calfromDate);
	  int setInvoice(InvoiceCalculationInput calfromDate);
	  int updateInvoiceZero(InvoiceCalculationInput calfromDate);
	  int updateInvoiceDetailZero(InvoiceCalculationInput calfromDate);
	  int updateInvoiceCalculationZero(InvoiceCalculationInput calfromDate);
	  int updateLastInvoicedt(InvoiceCalculationInput calfromDate);
	  int updateNextInvoicedt(InvoiceCalculationInput calfromDate);
	  List<InvoiceCalculation> getCalculationInvoice(InvoiceCalculationInput calfromDate);
	  List<Invoice> getZeroInvoicetoDelivery(InvoiceCalculationInput calfromdate);
	 
	  /*invoice Prepay calculation*/
	  int setInvoiceCalculationPrepay(InvoiceCreatePrePayInvoiceInput idi);
	  int setInvoiceCalculationDiscountRatePrepay(InvoiceCreatePrePayInvoiceInput idi);
	  int setInvoiceCalculationDiscountAmountPrepay(InvoiceCreatePrePayInvoiceInput idi);
	  int setInvoiceCalculationDiscountOneTimeFeePrepay(InvoiceCreatePrePayInvoiceInput idi);
	  int setInvoiceDetailPrepay(InvoiceCreatePrePayInvoiceInput idi);
	  int updateInvoiceDetailPrepay(InvoiceCreatePrePayInvoiceInput idi);
	  int updateInvoiceCalculationPrepay(InvoiceCreatePrePayInvoiceInput idi);
	  int setInvoicePrepay(InvoiceCreatePrePayInvoiceInput idi);
	  //int updateInvoiceInvoicedatePrepay(InvoiceCreatePrePayInvoiceInput idi);
	  //int updateInvoiceDetailInvoicedatePrepay(InvoiceCreatePrePayInvoiceInput idi);
	  //int updateInvoiceCalculationInvoicedatePrepay(InvoiceCreatePrePayInvoiceInput idi);
	  PaymentPrePayInvoiceInput getPrePayInvoice(InvoiceCreatePrePayInvoiceInput idi);
	  

	 
	 
	/*recurring */
	List<InvoiceCalculation> getInvoiceRecurringpayment(String calfromDate);
	
	/*payment proc*/
	int setPaymentHistory(PaymentHistoryInput input);
	int updateColInvoice(PaymentHistoryInput input);
	int updateColInvoiceDetail(PaymentHistoryInput input);
	int setRefundHistory(PaymentHistoryInput input);
	int updaterefundColInvoice(PaymentHistoryInput input);
	int updaterefundColInvoiceDetail(PaymentHistoryInput input);
	
	/*adjust proc*/
	int setInvoiceAdjust(InvoiceAdjustInput input);
	int updateInvoiceAdjust(InvoiceAdjustInput input);
	int setInvoiceAdjustInvoiceDetail(InvoiceAdjustInput input);
	int updateInvoiceAdjustInvoiceDetail(InvoiceAdjustInput input);
	int updateInvoiceAdjustAply(InvoiceAdjustInput input);
	int checkInvoiceAdjust(InvoiceAdjustInput input);
	
	/*invoice send*/
	int sendInvoiceSum(InvoiceDetailInput idi);
	
	/*paging cnt */
	int getInvoiceTotCount(InvoiceDateInput idi);
	int getInvoiceNameTotCount(InvoiceNameInput idi);
	int getPaymentHistoryTotCount(InvoiceDetailInput idi);
	
}
