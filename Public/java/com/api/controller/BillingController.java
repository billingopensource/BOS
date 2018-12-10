package com.api.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
import com.api.billing.invoice.model.PaymentPrePayInvoiceInput;
import com.api.billing.invoice.model.invoiceCounSelling;
import com.api.billing.login.model.User;
import com.api.billing.invoice.model.InvoiceCustomerInfo;
import com.api.billing.invoice.model.InvoiceCreatePrePayInvoiceInput;
import com.api.billing.model.delivery.DeliveryDateInput;
import com.api.billing.model.delivery.DeliveryPackageInput;
import com.api.model.Criteria;
import com.api.model.PageMaker;
import com.api.service.DeliveryService;
import com.api.service.InvoiceService;
import com.api.service.UserService;
import com.api.service.logic.VerifyPaymentByPayPal;


@RestController
@RequestMapping(value = "billing")
public class BillingController {
	
	@Autowired
	InvoiceService invoiceservice;

	@Autowired
	DeliveryService deliveryservice;
	
	@Autowired UserService userService;
	 
	 @RequestMapping(value = "/exceltest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewTest(Model model) {
		System.out.println("===================excelupload=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("excelupload");
		return modelAndView;
	 }
	 
	 /*search bar*/
	 @RequestMapping(value = "/searchbar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewSearchBar(Model model) {
		System.out.println("===================searchbar=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/searchbar");
		return modelAndView;
	 }
	 
	 /*search bar-datepicker*/
	 @RequestMapping(value = "/searchbardatepicker", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewSearchDateBar(Model model) {
		System.out.println("===================searchbar-datepicker=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/searchbar-datepicker");
		return modelAndView;
	 }
	 
	 
	 /*billing Controller*/
	 @RequestMapping(value = "/loadinggif", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewloading() {
		System.out.println("===================loadinggif=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loading");
		return modelAndView;
	 }
	 @RequestMapping(value = "/main", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewInvoice(Model model) {
		System.out.println("===================viewInvoice=====================");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/billing");
		return modelAndView;
	 }
	 /*Menu*/
	 @RequestMapping(value = "/billingmenu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewBillingemenu(Model model) {
		System.out.println("===================viewInvoice=====================");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/billingmenu");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/billing-invoice-status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewInvoiceMain(Model model) {
		System.out.println("===================billingmain=====================");
		//List<Invoice> invoicelist = invoiceservice.getInvoiceByDate();
		ModelAndView modelAndView = new ModelAndView();
		//model.addAttribute("invoicelist",invoicelist);
		modelAndView.setViewName("admin/billing/billing-invoice-status");
		return modelAndView;
	 }
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/getinvoicelistbyname", method = RequestMethod.GET)
	 public Map<String, Object> getInvoicelistByName(@ModelAttribute InvoiceNameInput invoicenameinput,Model model,Principal principal) {
		
		Map<String, Object> map = new HashMap<>();
		Criteria cri = invoicenameinput;
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		invoicenameinput.setProvidernumber(user.getProvidernumber());
		invoicenameinput.setUsername(user.getUsername());
		/*ID mapping*/
		map.put("lists", invoiceservice.getInvoiceByName(invoicenameinput)); // 리스트fetch
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(invoiceservice.getInvoiceNameTotCount(invoicenameinput));
		System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
		map.put("pageMaker", pageMaker); 
		return map;
	 }
	 

	 
	 @RequestMapping(value = "/getpaymentdetail", method = RequestMethod.GET)
	 public Map<String, Object> getPaymentHistoryDetail(@ModelAttribute InvoiceDetailInput invoicedetailinput,Model model,Principal principal) {
		System.out.println("===================getPaymentHistoryDetail=====================");
		Map<String, Object> map = new HashMap<>();
		Criteria cri = invoicedetailinput;
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		invoicedetailinput.setProvidernumber(user.getProvidernumber());
		invoicedetailinput.setUsername(user.getUsername());
		/*ID mapping*/
		map.put("lists",invoiceservice.getPaymentHistory(invoicedetailinput)); // 리스트fetch
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(invoiceservice.getPaymentHistoryTotCount(invoicedetailinput));
		System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
		map.put("pageMaker", pageMaker); 
		return map;
	 }

	 @RequestMapping(value = "/getinvoicelist", method = RequestMethod.GET)
	 public Map<String, Object> getInvoicelist(@ModelAttribute InvoiceDateInput invoicedateinput
			 ,Model model
			 ,Principal principal) {
		System.out.println("===================getinvoicelist=====================" + principal.getName());
		
		
		
		Map<String, Object> map = new HashMap<>();
		Criteria cri = invoicedateinput;
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		invoicedateinput.setProvidernumber(user.getProvidernumber());
		invoicedateinput.setUsername(user.getUsername());
		/*ID mapping*/
		
		map.put("lists", invoiceservice.getInvoiceByDate(invoicedateinput)); // 리스트fetch
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(invoiceservice.getInvoiceTotCount(invoicedateinput));

		System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
		map.put("pageMaker", pageMaker); 
		return map;
	 }
	 
	 
	 
	 @RequestMapping(value = "/insertCounsellingHistory", method = RequestMethod.GET)
	 public int insertCounsellingHistory(@ModelAttribute invoiceCounSelling invoicecounselling,Model model,Principal principal) {
		System.out.println("===================insertCounsellingHistory=====================");
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		invoicecounselling.setProvidernumber(user.getProvidernumber());
		invoicecounselling.setUsername(user.getUsername());
		/*ID mapping*/
		int result = invoiceservice.insertCounsellingHistory(invoicecounselling); // 리스트fetch
		return result;
	 }
	 
	 @RequestMapping(value = "/getCounsellingData", method = RequestMethod.GET)
	 public Map<String, Object> getCounsellingData(@ModelAttribute invoiceCounSelling invoicecounselling,Model model,Principal principal) {
		System.out.println("===================getCounsellingData=====================");
		Map<String, Object> map = new HashMap<>();
		Criteria cri = invoicecounselling;
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		invoicecounselling.setProvidernumber(user.getProvidernumber());
		invoicecounselling.setUsername(user.getUsername());
		/*ID mapping*/
		map.put("lists", invoiceservice.getCounsellingData(invoicecounselling)); // 리스트fetch
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(invoiceservice.getCounsellingTotalCount(invoicecounselling));

		System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
		map.put("pageMaker", pageMaker); 
		return map;
	 }
	 
	 @RequestMapping(value = "/billing-calculation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewBillingCalaulation(Model model) {
		System.out.println("===================viewBillingCalaulation=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/billing-calculation");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/billing-recurringpayment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewBillingRecurringpayment(Model model) {
		System.out.println("===================viewBillingRecurringpayment=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/billing-recurringpayment");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/billing-calculation/{calfromdate}/{gubun}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public int setBillingCalaulation(@PathVariable(value = "calfromdate") String calfromdate
		                          	 ,@PathVariable(value = "gubun") int gubun
			                         ,Model model
			                         ,Principal principal) {
		System.out.println("===================setBillingCalaulation=====================");
		System.out.println("calfromdate = " + calfromdate);
		InvoiceCalculationInput ici = new InvoiceCalculationInput();
		ici.setCalfromDate(calfromdate);
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		ici.setProvidernumber(user.getProvidernumber());
		ici.setUsername(user.getUsername());
		/*ID mapping*/
		int result = 0 ;
		switch (gubun) {
		case 1:
			result = insertInvoiceCalculation(ici);
			break;
		case 2:
			result = insertInvoiceCalculationDiscount(ici);
			break;
		case 3:
			result = insertInvoiceDetail(ici);
			break;
		case 4:
			result = insertInvoice(ici);
			break;
		default:
			break;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	 }
	 
	 @RequestMapping(value = "/billing-calculation-view/{calfromdate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public List<InvoiceCalculation> setviewBillingCalaulation(@PathVariable(value = "calfromdate") String calfromdate
			                         ,Model model
			                         ,Principal principal) {
		System.out.println("===================setBillingCalaulation=====================");
		System.out.println("calfromdate = " + calfromdate);
		InvoiceCalculationInput ici = new InvoiceCalculationInput();
		ici.setCalfromDate(calfromdate);
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		ici.setProvidernumber(user.getProvidernumber());
		ici.setUsername(user.getUsername());
		/*ID mapping*/
		List<InvoiceCalculation> resultlist = invoiceservice.getCalculationInvoice(ici);
		
		return resultlist;
	 }
	 
	 @RequestMapping(value = "/billing-recalculation-view/{calfromdate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public List<InvoiceCalculation> setviewBillingRecalculation(@PathVariable(value = "calfromdate") String calfromdate
			                         ,Model model
			                         ,Principal principal) {
		System.out.println("===================setviewBillingRecalculation=====================");
		System.out.println("calfromdate = " + calfromdate);
		List<InvoiceCalculation> resultlist = invoiceservice.getInvoiceRecurringpayment(calfromdate);
		
		return resultlist;
	 }
	 
	 public int insertInvoiceCalculation(InvoiceCalculationInput calfromdate) {
	   int result = 0 ;
	   result = invoiceservice.setInvoiceCalculation(calfromdate);
	   if(result == 0) {
	    
	    return result; 
	   }
	   return result; 
	   
	 }
		  
	  public int insertInvoiceCalculationDiscount(InvoiceCalculationInput calfromdate) {
	   int result = 1 ;
	   result += invoiceservice.setInvoiceCalculationDiscountRate(calfromdate);
	   result += invoiceservice.setInvoiceCalculationDiscountAmount(calfromdate);
	   result += invoiceservice.setInvoiceCalculationDiscountOneTimeFee(calfromdate);
	  /* result += invoiceservice.setInvoiceCalculationGeneralTax(calfromdate);
	   result += invoiceservice.setInvoiceCalculationDiscountTax(calfromdate); 20180911 수정*/
	   return result; 
	  }
		  
	  public int insertInvoiceDetail(InvoiceCalculationInput calfromdate) {
	   int result = 0 ;
	   result += invoiceservice.setInvoiceDetail(calfromdate);
	   result += invoiceservice.updateInvoiceDetail(calfromdate);
	   result += invoiceservice.updateInvoiceCalculation(calfromdate);
	   return result; 
	  }
		  
	  public int insertInvoice(InvoiceCalculationInput calfromdate) {
	   int result = 0 ;
	   result = invoiceservice.setInvoice(calfromdate);
	   if(result == 0) {
	    return result; 
	   }
	   result = invoiceservice.updateInvoiceZero(calfromdate);
	   result = invoiceservice.updateInvoiceDetailZero(calfromdate);
	   result = invoiceservice.updateInvoiceCalculationZero(calfromdate);
	   result = invoiceservice.updateLastInvoicedt(calfromdate);
	   result = invoiceservice.updateNextInvoicedt(calfromdate);
	   result += getZeroInvoicetoDelivery(calfromdate);
	    
	    return result; 
	   }
	   
	public int getZeroInvoicetoDelivery(InvoiceCalculationInput calfromdate) {
		int result = 0;
		PaymentHistoryInput paymenthistoryinput = new PaymentHistoryInput();

		List<Invoice> invoicelist = invoiceservice.getZeroInvoicetoDelivery(calfromdate);
		if (invoicelist.size() > 0) {
			for (int i = 0; i < invoicelist.size(); i++) {
				System.out.println(
						"======ZERO INVO DELIVERY HIST UPDATE 대상 : getConNumber() /" + invoicelist.get(i).getConNumber()
								+ " / getInvoiceDate() / " + invoicelist.get(i).getInvoiceDate()
								+ " / getInvoicenumber() / " + invoicelist.get(i).getInvoicenumber()  );
				paymenthistoryinput.setInvoicenumber(invoicelist.get(i).getInvoicenumber());
				paymenthistoryinput.setInvoicedate(invoicelist.get(i).getInvoiceDate());
				result = deliveryservice.insertDeliveryDetail(paymenthistoryinput);
			}
		} else {
			System.out.println("====== 요금생성 결과 ZERO INVO 중 DELIVERY HIST UPDATE할 대상 없습니다. ========");
		}

		return result;
	}
	 
	 @RequestMapping(value = "/billing-customer-paymentlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewBillingCustomerList(Model model,Principal principal) {
		System.out.println("===================viewInvoice=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/billing-customer-paymentlist");
		return modelAndView;
	 }
	 
	 /*invoice detail modal*/
	   @RequestMapping(value = "/invoiceDetail/{invoicenumber}/{invoicedate}/{connumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	   public ModelAndView viewinvoiceDetail(@PathVariable(value = "invoicenumber") int invoicenumber
	                           ,@PathVariable(value = "invoicedate") String invoicedate
	                           ,@PathVariable(value = "connumber") int connumber
	                           ,Model model
	                           ,Principal principal) {
	   System.out.println("===================invoiceDetail=====================");
	   System.out.println("invoicenumber = " + invoicenumber + " / invoicedate = " + invoicedate + "/" + connumber);
	   InvoiceDetailInput invoicedetailinput = new InvoiceDetailInput();
	   invoicedetailinput.setInvoiceDate(invoicedate);
	   invoicedetailinput.setInvoiceNumber(invoicenumber);
	   invoicedetailinput.setConNumber(connumber);
	   /*ID mapping*/
		User user = userService.readUser(principal.getName());
		invoicedetailinput.setProvidernumber(user.getProvidernumber());
		invoicedetailinput.setUsername(user.getUsername());
		/*ID mapping*/
	   List<InvoiceDetail> invoicedetaillist = invoiceservice.getInvoiceDetail(invoicedetailinput);
	   InvoiceDetailCustomerInfo invoicecustomerinfo = invoiceservice.getInvoiceDetailCustomerInfo(invoicedetailinput);
	   List <InvoiceDetailProductInfo> invoiceproductinfolist = invoiceservice.getInvoiceDetailProductInfo(invoicedetailinput);
	   
	   String productinfo = invoiceproductinfolist.get(0).getMainProductName();  
	   if(invoiceproductinfolist.get(0).getCompositionProductId().equals("")) {
	    productinfo += " 상품은 단품 구성 상품입니다.";  
	   }else{
	    productinfo += "는 패키지 상품이며 , 구성품은 ";
	    for (int i = 0 ; i < invoiceproductinfolist.size() ; i ++) {
	     productinfo += invoiceproductinfolist.get(i).getCompositionProductName();
	     productinfo += invoiceproductinfolist.get(i).getCompositionPriceAmount();
	     if (i != (invoiceproductinfolist.size() -1)) {
	      productinfo += ",";
	     }
	    }
	    productinfo += " 입니다. ";
	   }
	   System.out.println("invoiceproductinfo : " + productinfo);
	   if(invoicecustomerinfo == null) {
	    invoicecustomerinfo = new InvoiceDetailCustomerInfo();
	   }
	   InvoiceTaxItemInfo itii = invoiceservice.getInvoiceTaxItemAmount(invoicedetailinput);
	   ModelAndView modelAndView = new ModelAndView();
	   model.addAttribute("invoicedetaillist",invoicedetaillist);
	   model.addAttribute("invoicecustomerinfo",invoicecustomerinfo);
	   model.addAttribute("itii",itii);
	   model.addAttribute("invoicenumber",invoicenumber);
	   model.addAttribute("invoicedate",invoicedate);
	   model.addAttribute("connumber",connumber);
	   model.addAttribute("productinfo",productinfo);
	   modelAndView.setViewName("popup/invoicedetailPopup");
	   return modelAndView;
	   }

	 
	 /*invoice adjust modal*/
	 @RequestMapping(value = "/invoiceAdjust/{invoicenumber}/{invoicedate}/{connumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewinvoiceAdjust(@PathVariable(value = "invoicenumber") int invoicenumber
			                       ,@PathVariable(value = "invoicedate") String invoicedate
			                       ,@PathVariable(value = "connumber") int connumber
			                       ,Model model
			                       ,Principal principal) {
		System.out.println("===================invoiceAdjust=====================");
		System.out.println("invoicenumber = " + invoicenumber + " / invoicedate = " + invoicedate + "/" + connumber);
		InvoiceDetailInput invoicedetailinput = new InvoiceDetailInput();
		invoicedetailinput.setInvoiceDate(invoicedate);
		invoicedetailinput.setInvoiceNumber(invoicenumber);
		invoicedetailinput.setConNumber(connumber);
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		invoicedetailinput.setProvidernumber(user.getProvidernumber());
		invoicedetailinput.setUsername(user.getUsername());
		/*ID mapping*/
		List<InvoiceAdjust> invoiceadjustlist = invoiceservice.getInvoiceAdjust(invoicedetailinput);
		
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("invoiceadjustlist",invoiceadjustlist);
		model.addAttribute("invoicenumber",invoicenumber);
		model.addAttribute("invoicedate",invoicedate);
		model.addAttribute("connumber",connumber);
		modelAndView.setViewName("popup/adjustPopup");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/paymentDialog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewpaymentDialog(Model model) {
		System.out.println("===================paymentDialog=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("popup/paymentPopup");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/adjustPopup/{invoicenumber}/{invoicedate}/{connumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewadjustDialog(@PathVariable(value = "invoicenumber") int invoicenumber
             ,@PathVariable(value = "invoicedate") String invoicedate
             ,@PathVariable(value = "connumber") int connumber
             ,Model model) {
		System.out.println("===================adjustPopup=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("popup/adjustPopup");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/refundDialog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewrefundDialog(Model model) {
		System.out.println("===================refundPopup=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("popup/refundPopup");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/adjust-payment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewPayment(Model model) {
		System.out.println("===================paymentview=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/payment-view");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/refund", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewRefund(Model model) {
		System.out.println("===================viewInvoice=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/refund-view");
		return modelAndView;
	 }
	 /*calendar*/
	 @RequestMapping(value = "/billing-board", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewBillingBoard(Model model) {
		System.out.println("===================viewInvoice=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/payment-board");
		return modelAndView;
	 }
	 
	 @RequestMapping(value = "/paymentproc", method = RequestMethod.POST)
	 public int procPayment(@ModelAttribute PaymentHistoryInput paymenthistoryinput,Model model,Principal principal) {
		System.out.println("===================paymentproc=====================");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int result = 0 ;
	    /*ID mapping*/
		User user = userService.readUser(principal.getName());
		paymenthistoryinput.setProvidernumber(user.getProvidernumber());
		paymenthistoryinput.setUsername(user.getUsername());
		/*ID mapping*/
	    if(paymenthistoryinput.getChannelgubun() == null)
	    {
	    	paymenthistoryinput.setChannelgubun("N");
	    }
	    result = invoiceservice.setPaymentHistory(paymenthistoryinput);
	    
	    if(result == 0) {
			return result;	
		 }
	    result = invoiceservice.updateColInvoice(paymenthistoryinput);
	    result = invoiceservice.updateColInvoiceDetail(paymenthistoryinput);
	    if(paymenthistoryinput.getChannelgubun().equals("P")) {
	    	return result;
	    }else {
	    	deliveryservice.insertDeliveryDetail(paymenthistoryinput);
	    }
		return result;
	 }
	 
	 @RequestMapping(value = "/refundproc", method = RequestMethod.POST)
	 public int procRefund(@ModelAttribute PaymentHistoryInput paymenthistoryinput,Model model,Principal principal) {
		System.out.println("===================refundproc=====================");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int result = 0 ;
	    /*ID mapping*/
		User user = userService.readUser(principal.getName());
		paymenthistoryinput.setProvidernumber(user.getProvidernumber());
		paymenthistoryinput.setUsername(user.getUsername());
		/*ID mapping*/
	    result = invoiceservice.setRefundHistory(paymenthistoryinput);
	    if(result == 0) {
			return result;	
		 }
	    result = invoiceservice.updaterefundColInvoice(paymenthistoryinput);
	    result = invoiceservice.updaterefundColInvoiceDetail(paymenthistoryinput);
		return result;
	 }
	 
	 @RequestMapping(value = "/recurringproc/{invoicenumber}/{connumber}/{invoicedate}/{paymentamt}", method = RequestMethod.POST)
	 public int procRecurring(@PathVariable(value = "invoicenumber") int invoicenumber
             ,@PathVariable(value = "invoicedate") String invoicedate
             ,@PathVariable(value = "connumber") int connumber
             ,@PathVariable(value = "paymentamt") int paymentamt
             ,Model model
             ,Principal principal) {
		PaymentHistoryInput paymenthistoryinput = new PaymentHistoryInput(invoicenumber, invoicedate, connumber ,paymentamt, "11PAYA") ;
		System.out.println("===================recurringproc=====================");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int result = 0 ;
	    result = invoiceservice.setPaymentHistory(paymenthistoryinput);
	    if(result == 0) {
			return result;	
		 }
	    result = invoiceservice.updateColInvoice(paymenthistoryinput);
		return result;
	 }
	 
	@RequestMapping(value = "/adjust", method = RequestMethod.GET)
	public int procAdjust(
			@RequestParam("invoiceClassificationCode") String invoiceClassificationCode,
			@RequestParam("revenueItemCode") String revenueItemCode,
			@RequestParam("adjustPossibleAmount") int adjustPossibleAmount, 
			@RequestParam("adjustamt") int adjustamt,
			@RequestParam("adjustinvoicenumber") int adjustinvoicenumber,
			@RequestParam("adjustinvoicedate") String adjustinvoicedate,
			@RequestParam("adjustconnumber") int adjustconnumber,
			@RequestParam("adjustreasonmessage") String adjustreasonmessage, Model model,Principal principal) {
		System.out.println("===================adjustproc=====================");
		System.out.println("invoiceClassificationCode = " + invoiceClassificationCode
				          +"revenueItemCode = " + revenueItemCode
				          +"adjustPossibleAmount = " + adjustPossibleAmount
				          +"adjustinvoicenumber = " + adjustinvoicenumber
				          +"adjustinvoicedate = " + adjustinvoicedate
				          +"adjustconnumber = " + adjustconnumber
				          +"adjustreasonmessage = " + adjustreasonmessage
				);
		InvoiceAdjustInput iai = new InvoiceAdjustInput(adjustinvoicenumber, adjustinvoicedate, adjustconnumber,
				invoiceClassificationCode, revenueItemCode, adjustPossibleAmount, adjustamt, adjustreasonmessage);
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		iai.setProvidernumber(user.getProvidernumber());
		iai.setUsername(user.getUsername());
		/*ID mapping*/
		int result = 0;
		System.out.println("===================setInvoiceAdjust=====================");
		result = invoiceservice.setInvoiceAdjust(iai);
		if (result == 0) {
			return result;
		}
		int gubun = invoiceservice.checkInvoiceAdjust(iai);
		if(gubun > 0 ) {
			System.out.println("===================updateInvoiceAdjust=====================");
			result = invoiceservice.updateInvoiceAdjust(iai);
			if (result == 0) {
				return result;
			}
		}else {
			System.out.println("===================setInvoiceAdjustInvoiceDetail=====================");
			result = invoiceservice.setInvoiceAdjustInvoiceDetail(iai);
			if (result == 0) {
				return result;
			}
		}
		
		System.out.println("===================updateInvoiceAdjustInvoiceDetail=====================");
		result = invoiceservice.updateInvoiceAdjustInvoiceDetail(iai);
		if (result == 0) {
			return result;
		}
		System.out.println("===================updateInvoiceAdjustAply=====================");
		result = invoiceservice.updateInvoiceAdjustAply(iai);
		if (result == 0) {
			return result;
		}
		return result;

	}
	
	@RequestMapping(value = "/sendEmailPopup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewsendEmailPopup(Model model) {
		System.out.println("===================sendEmailPopup=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("popup/sendEmailPopup");
		return modelAndView;
	 }
	
	@RequestMapping(value = "paypalrcv", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public void paypalrcv(HttpServletRequest request) {
		System.out.println("===================paypalrcv=====================");
		PaymentHistoryInput paymenthistoryinput = new PaymentHistoryInput(1234, "20180906", 1234 ,10, "PAYPAL") ;

	    invoiceservice.setPaymentHistory(paymenthistoryinput);
		//VerifyPaymentByPayPal vp =  new VerifyPaymentByPayPal();
		
	 }
	
	// 배송대상조회
	@RequestMapping(value = "/deliverylist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewDeliveryList(Model model,Principal principal) {
		System.out.println("===================DELIVERY-deliverylist=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/deliverylist");
		return modelAndView;
	}

	/* 배송대상조회 search bar-datepicker */
	@RequestMapping(value = "/searchbardelivery", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewSearchDateBarDelivery(Model model) {
		System.out.println("===================DELIVERY-searchbar-delivery=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/searchbar-delivery");
		return modelAndView;
	}

	// 배송대상조회 - 실제조회내용
	@RequestMapping(value = "/getdeliverylist", method = RequestMethod.GET)
	public Map<String, Object> getDeliverylist(@ModelAttribute DeliveryDateInput deliverydateinput, Model model,Principal principal) {
		System.out.println("===================DELIVERY-getdeliverylist=====================");
		System.out.println(deliverydateinput.getFromDateD());
		System.out.println(deliverydateinput.getToDateD());
		Map<String, Object> map = new HashMap<>();
		Criteria cri = deliverydateinput;
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		deliverydateinput.setProvidernumber(user.getProvidernumber());
		deliverydateinput.setUsername(user.getUsername());
		/*ID mapping*/
		
		map.put("lists", deliveryservice.getDeliveryByDate(deliverydateinput)); // 리스트fetch
		// System.out.println(map.get("lists") );
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(deliveryservice.getDeliveryTotCount(deliverydateinput));

		System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
		map.put("pageMaker", pageMaker);
		return map;
	}

	// 배송대상조회 하단의 패키지내역 조회
	@RequestMapping(value = "/getPackageData", method = RequestMethod.GET)
	public Map<String, Object> getPackageData(@ModelAttribute DeliveryPackageInput deliverypackageinput, Model model,Principal principal) {
		System.out.println("===================DELIVERY-getPackageData=====================");
		Map<String, Object> map = new HashMap<>();
		Criteria cri = deliverypackageinput;
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		deliverypackageinput.setProvidernumber(user.getProvidernumber());
		deliverypackageinput.setUsername(user.getUsername());
		/*ID mapping*/
		map.put("lists", deliveryservice.getPackageData(deliverypackageinput)); // 리스트fetch
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(deliveryservice.getPackageTotalCount(deliverypackageinput));

		System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
		map.put("pageMaker", pageMaker);
		return map;
	}
	
	@RequestMapping(value = "/kakaopayready", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public String test(@ModelAttribute PaymentHistoryInput paymenthistoryinput
			            ,Model model
			            ,Principal principal) {
		System.out.println("===================kakaopayready=====================");
		//session.setAttribute(UserConfig, value);
	    //session.setAttribute(UserConfig.SESS_USER_ID, '1');
	    //session.setAttribute(UserConfig.SESS_USER_NAME, '2');
	    // expired in 10 minutes
	    //session.setMaxInactiveInterval(60 * 10);
		SendCurl sc = new SendCurl(paymenthistoryinput.getItemname()
	            , "1"
	            , String.valueOf(paymenthistoryinput.getPaymentamt())
	            , "0"
	            , paymenthistoryinput.getVatamount()
	            , paymenthistoryinput.getInvoicenumber()
	            , paymenthistoryinput.getInvoicedate()
	            , paymenthistoryinput.getConnumber()
	            , paymenthistoryinput.getPaymentamt()
	            );
		sc.payKaKaoPay();
		paymenthistoryinput = sc.setTidvalue(paymenthistoryinput);
		System.out.println("connumber = " +paymenthistoryinput.getConnumber()
		        + "invoicedate = " +paymenthistoryinput.getInvoicedate()
		        + "invoicenumber = " +paymenthistoryinput.getInvoicenumber()
		        + "paymentamt = " +paymenthistoryinput.getPaymentamt()
		        + "tid = " +paymenthistoryinput.getTid()
		);
		int result = invoiceservice.insertPgpaymentlist(paymenthistoryinput);
		if(result != 1) {
			return "insertPgpaymentlist error";
		}
		return sc.payKaKaoPay();
	 }
	
	@RequestMapping(value = "/success", method = {RequestMethod.GET,RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView kakaosuccess(
			@RequestParam("paymentamt") int paymentamt,
			@RequestParam("invoicenumber") int invoicenumber,
			@RequestParam("invoicedate") String invoicedate,
			@RequestParam("connumber") int connumber
			 ,Model model
			 ,Principal principal) 
	{
		PaymentHistoryInput paymenthistoryinput = new PaymentHistoryInput(invoicenumber, invoicedate, connumber ,paymentamt, "KAKAOPAY") ;
		//session.setAttribute(UserConfig, value);
	    //session.setAttribute(UserConfig.SESS_USER_ID, '1');
	    //session.setAttribute(UserConfig.SESS_USER_NAME, '2');
	    // expired in 10 minutes
	    //session.setMaxInactiveInterval(60 * 10);
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		paymenthistoryinput.setProvidernumber(user.getProvidernumber());
		paymenthistoryinput.setUsername(user.getUsername());
		/*ID mapping*/
		int result = 0;
		result = invoiceservice.setPaymentHistory(paymenthistoryinput);
		result = invoiceservice.updateColInvoice(paymenthistoryinput);
		result = invoiceservice.updateColInvoiceDetail(paymenthistoryinput);
		deliveryservice.insertDeliveryDetail(paymenthistoryinput);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/billing/kakaosuccess");
		return modelAndView;
	 }
	
}
