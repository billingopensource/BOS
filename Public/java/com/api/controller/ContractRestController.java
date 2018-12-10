package com.api.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.billing.invoice.model.InvoiceCreatePrePayInvoiceInput;
import com.api.billing.invoice.model.PaymentPrePayInvoiceInput;
import com.api.billing.login.model.User;
import com.api.billing.model.contract.BatchContract;
import com.api.billing.model.contract.Contract;
import com.api.billing.model.contract.ContractInput;
import com.api.billing.model.contract.ContractInsert;
import com.api.billing.model.contract.CouponBalance;
import com.api.billing.model.contract.CouponUseHistory;
import com.api.billing.model.contract.Discount2;
import com.api.billing.model.contract.DiscountEffectDate;
import com.api.billing.model.contract.PaymentInfoInsert;
import com.api.billing.model.contract.PaymentInformation;
import com.api.billing.model.contract.Product;
import com.api.billing.model.contract.Product2;
import com.api.billing.model.customer.Address;
import com.api.billing.model.customer.CounsellingHistory;
import com.api.billing.model.customer.Customer;
import com.api.billing.model.customer.CustomerCharacteristic;
import com.api.billing.model.customer.CustomerSearchBar;
import com.api.billing.model.product.Discount;
import com.api.billing.model.product.DiscountSearchBar;
import com.api.billing.model.product.Product3;
import com.api.billing.model.product.ProductPackage;
import com.api.model.Criteria;
import com.api.model.PageMaker;
import com.api.service.ContractService;
import com.api.service.CustomerService;
import com.api.service.InvoiceService;
import com.api.service.ProductService;
import com.api.service.UserService;

@RestController
@RequestMapping("contract")
public class ContractRestController {

	@Autowired
	private ContractService contractService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping(value = "/contractmain", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewContractMain(Model model) {
		System.out.println("____________________viewContractMain____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/contract/contractmain");
		return modelAndView;
	}
	
	@RequestMapping(value = "/contractmenu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewContractMenu(Model model) {
		System.out.println("____________________viewContractMenu____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/contract/contractmenu");
		return modelAndView;
	}

	@RequestMapping(value = "/productsale", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewProductSale() {
		System.out.println("____________________viewProductSale____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/contract/productsale");
		return modelAndView;
	}
		
	@RequestMapping(value = "/productsale/selectedcustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewProductSaleByCustomerNumber(
			@PathVariable(value = "customernumber") int customerNumber
			) {
		System.out.println("____________________viewProductSaleByCustomerNumber____________________");
		
		Customer customer = contractService.findCustomerByCustomerNumber(customerNumber);
		List<Contract> contract = contractService.findContractByCustomerNumber(customerNumber);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/contract/productsale");
		modelAndView.addObject("customerResult", customer);
		modelAndView.addObject("contractListResult", contract);
		return modelAndView;
	}

	@RequestMapping(value = "/paymentinformation/{connumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewPaymentInformation(@PathVariable(value = "connumber") int connumber) {
		System.out.println("____________________viewPaymentInformation____________________");
		PaymentInformation paymentInformation = contractService.findPaymentInformationByConNumber(connumber);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/contract/paymentInformation");
		modelAndView.addObject("paymentInformationResult", paymentInformation);
		return modelAndView;
	}
	
	@RequestMapping(value = "/contractSearchbar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewSearchBar(Model model) {
		System.out.println("____________________viewSearchBar____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/contract/contractsearchbar");
		return modelAndView;
	}
		
	@RequestMapping(value = "/findsearchbar", method = RequestMethod.GET)
	public ModelAndView findCustomerBySearchBar(@ModelAttribute CustomerSearchBar customerSearchBar
			, Model model
			, Principal principal) {
		System.out.println("____________________findCustomerBySearchBar____________________");
		System.out.println("customerSearchBar.getCustomerName() = " + customerSearchBar.getCustomerName());
		System.out.println("customerSearchBar.getPhoneNumber() = " + customerSearchBar.getPhoneNumber());
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		customerSearchBar.setProvidernumber(user.getProvidernumber());
		customerSearchBar.setUsername(user.getUsername());
		/*ID mapping*/
		List<Customer> customer = contractService.findCustomerBySearchBar(customerSearchBar);
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("customer.size() = " + customer.size());
		modelAndView.setViewName("popup/customerlistpopup");
		modelAndView.addObject("customerListResult", customer);
		return modelAndView;
	}
	
	@RequestMapping(value = "/findAllProduct", method = RequestMethod.GET)
	public List<Product3> findAllProduct(Principal principal) {
		System.out.println("____________________findAllProduct____________________");
		List<Product3> product = contractService.findAllProduct();
		return product;
	}
	
	@RequestMapping(value = "/findAllDiscount", method = RequestMethod.GET)
	public List<Discount> findAllDiscount(Principal principal) {
		System.out.println("____________________findAllDiscount____________________");
		List<Discount> discount = contractService.findAllDiscount();
		return discount;
	}
	
	@RequestMapping(value = "/customercreatepopup", method = RequestMethod.GET)
	public ModelAndView viewCustomerCreatePopup(Model model) {
		System.out.println("____________________viewCustomerCreatePopup____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("popup/customercreatepopup");
		return modelAndView;
	}
	
	@RequestMapping(value = "/couponuse", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewCouponUse() {
		System.out.println("____________________viewProductSale____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/contract/productsaletemplate");
		return modelAndView;
	}
	
	//추가
	/*new contract*/
	 @RequestMapping(value = "/productsale/newcontract/{customernumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView NewContract(@PathVariable(value= "customernumber") int customernumber) {
		System.out.println("===================new contract=====================");
		
		List<Customer> customerList = contractService.getFindCustomerList(customernumber);
		System.out.println("customerList==>"+customerList);
		
		ModelAndView modelAndView = new ModelAndView();
				
		modelAndView.addObject("customerList", customerList);
		modelAndView.setViewName("admin/contract/newcontract");
		return modelAndView;
	 }
		 
	 /*productListPopup searchbar 연계*/
	 @RequestMapping(value = "/getProductListPopup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public List<Product2> getProductListPopup(@ModelAttribute Product2 product, Model model,Principal principal) {
		
		System.out.println("===================getProductListPopup=====================");
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		product.setProvidernumber(user.getProvidernumber());
		product.setUsername(user.getUsername());
		/*ID mapping*/
		List<Product2> productList = contractService.getProductList(product);

		System.out.println("productlist.size = " + productList.size());
		System.out.println("productList  : " + productList);
	
		return productList;
	 }
	 
	 @RequestMapping(value = "/productListPopup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView ProductListPopup(Model model) {
		
		 System.out.println("===================productListPopup=====================");
	
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("popup/productListPopup");
		 return modelAndView;
	 }
	 
	 /* discountListPopup searchbar 연계*/
	 @RequestMapping(value = "/getdiscountlist", method = RequestMethod.GET)
	 public List<Discount2> getDiscountList(@ModelAttribute DiscountSearchBar discountSearchBar ,Model model,Principal principal) {
		System.out.println("===================getDiscountList=====================");
		System.out.println("discountSearchBar.getDiscountType() = " + discountSearchBar.getDiscountType() );
		System.out.println("discountSearchBar.getDiscountName() = " + discountSearchBar.getDiscountName() );
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		discountSearchBar.setProvidernumber(user.getProvidernumber());
		discountSearchBar.setUsername(user.getUsername());
		System.out.println("user.getProvidernumber() = " + user.getProvidernumber() );
		/*ID mapping*/
		List<Discount2> discountList = contractService.findDiscountBySearchBar(discountSearchBar);
		System.out.println("discountList.size = " + discountList.size());
		System.out.println("discountList = " + discountList);
		return discountList;
	 }
	 
	 /* discountListPopup searchbar 연계*/
	 @RequestMapping(value = "/findApplyDiscount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public List<Discount2> getFindApplyDiscountList(@ModelAttribute DiscountEffectDate discountEffectDate ,Model model,Principal principal) {
		System.out.println("===================getFindApplyDiscountList=====================");
		System.out.println("getFindApplyDiscountList.getDuration() = " + discountEffectDate.getDuration() );
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		discountEffectDate.setProvidernumber(user.getProvidernumber());
		discountEffectDate.setUsername(user.getUsername());
		/*ID mapping*/
		List<Discount2> discountList = contractService.getFindApplyDiscount(discountEffectDate);
		System.out.println("discountList.size = " + discountList.size());
		System.out.println("discountList = " + discountList);
		return discountList;
	 }
	 
	 /*discountListPopup (기간에 맞는 할인 목록만 가져오기 기능은 현재는 사용하지 않음)*/
	 @RequestMapping(value = "/discountListPopup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewDiscountListPopup(Model model) {
		System.out.println("===================discountListPopup=====================");
//		System.out.println("discountListPopup.effecStart() = " + discountEffectDate.getEffectiveStartDate());
//		System.out.println("discountListPopup.effectEnd() = " + discountEffectDate.getEffectiveEndDate());
//		List<Discount> discountList = contractService.getDiscountList(discountEffectDate);

//		System.out.println("discountList  : " + discountList);
//		model.addAttribute("discountList", discountList);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("popup/discountListPopup");
		return modelAndView;
		
	 }
	 
	 	 
	 /*contract Insert*/
	 @RequestMapping(value="/contractInsert", method=RequestMethod.POST)
	 public PaymentPrePayInvoiceInput createContract(@ModelAttribute ContractInsert contractInsert , Model model,Principal principal) {
		 System.out.println("===========paymentinformation insert=========");
		 /*ID mapping*/
		 User user = userService.readUser(principal.getName());
		 contractInsert.setProvidernumber(user.getProvidernumber());
		 contractInsert.setUsername(user.getUsername());
		 /*ID mapping*/
		 
		 contractInsert.setInvoiceCycle("MONTH");
		 
		 System.out.println("============paymentInfoInsert customerNumber=============" + contractInsert.getCustomerNumber());
		 System.out.println("============paymentInfoInsert deliveryType=============" + contractInsert.getInvoiceDeliveryType());
		 System.out.println("============paymentInfoInsert paymentMethod=============" + contractInsert.getPaymentMethod());
	   
		 System.out.println("===getProductType==="+contractInsert.getProductType());
		 
		 int addressInsertFlag = contractService.createDeliveryAddress(contractInsert);
		 Address address = contractService.findDeliverAddressId(contractInsert);
		 String addrId = address.getAddressId();
		 System.out.println("==addrId:======= " + addrId);
		 contractInsert.setDeliveryAddressId(addrId);	
		 System.out.println("==getDeliveryAddressId:======= "+contractInsert.getDeliveryAddressId());
		 int paymentInfoInsertFlag = contractService.paymentInfoInsert(contractInsert);
		 System.out.println("==paymentinformationnumber:======= "+contractInsert.getPaymentInformationNumber());	 	 
		 System.out.println("============paymentInfoInsert paymentinformationNumber=============" + contractInsert.getPaymentInformationNumber());
		 
		 
		 
		 System.out.println("============contract Insert=============");
				 
		 int duration = contractInsert.getDuration();
		 
		 contractInsert.setDeliveryTimes(duration);
		 contractInsert.setDeliveryTotalCount(duration);
		 contractInsert.setDeliveryRemainCount(duration);
		 
		 System.out.println("==TotalCount:==" + contractInsert.getDeliveryTotalCount());
		 
		int contractInsertFlag = contractService.createContract(contractInsert);
		 
		if(contractInsert.getPackageYn().equals("Y"))
		{
			System.out.println("==productID:======= "+contractInsert.getProductId());	
			ContractInsert contractInsertPackageId = contractService.findPackageId(contractInsert);
			
			contractInsert.setPackageId(contractInsertPackageId.getPackageId());
			System.out.println("==packageID:======= "+contractInsert.getPackageId());	
		}
		
		System.out.println("packagevarietyYn1===>"+ contractInsert.getPackageVarietyYn());
		if(contractInsert.getPackageVarietyYn() == "") {
			contractInsert.setPackageVarietyYn(null);
		}
		if(contractInsert.getPackagePriceReferenceYn() == "") {
			contractInsert.setPackagePriceReferenceYn(null);
		}
		
		System.out.println("packagevarietyYn2===>"+ contractInsert.getPackageVarietyYn());
		
		 int contractProductFlag = contractService.createContractProduct(contractInsert);
		 
		 if(contractInsert.getDiscountId() !=null)
		 {
			 int contractDiscountFlag = contractService.createContractDiscount(contractInsert);
	 	 }
		
		//20180920
		if(contractInsert.getProductType().equals("COUPONCOUNT")  || contractInsert.getProductType().equals("COUPONPRICE"))
		{	
			System.out.println("===productType==="+contractInsert.getProductType());
			System.out.println("===provider===" + contractInsert.getProvidernumber());
			System.out.println("===customernumber==="+ contractInsert.getCustomerNumber());
			//기존 등록 정보 확인
			CouponBalance couponBalance = contractService.findCouponBalanceWhenContractInsert(contractInsert);
			
			if(couponBalance==null)
			{
				couponBalance =  new  CouponBalance();
				couponBalance.setCouponType(contractInsert.getProductType());
				couponBalance.setCustomerNumber(contractInsert.getCustomerNumber());
				couponBalance.setProvidernumber(contractInsert.getProvidernumber());
				couponBalance.setUsername(contractInsert.getUsername());
				
				if(couponBalance.getCouponType().equals("COUPONCOUNT")) 
				{	
					System.out.println("===balance couponcount insert===="+ Integer.parseInt(contractInsert.getProductQuantity()));
					couponBalance.setCouponBalance(Integer.parseInt(contractInsert.getProductQuantity()));
				}
				else
				{	
					int couponPrice = contractInsert.getPriceAmount() * Integer.parseInt(contractInsert.getProductQuantity());
					System.out.println("===balance couponprice insert===="+ couponPrice);
					couponBalance.setCouponBalance(couponPrice);
				}
				//최초등록
				int createCouponBalacneFlag = contractService.createCouponBalanceWhenContractInsert(couponBalance);
				
			}
			else 
			{	
				if(couponBalance.getCouponType().equals("COUPONCOUNT")) 
				{   
					int couponcountupdate = couponBalance.getCouponBalance() + Integer.parseInt(contractInsert.getProductQuantity());
					System.out.println("===balance couponcount update====" + couponcountupdate);
					couponBalance.setCouponBalance(couponcountupdate);
				}
				else
				{
					int couponPrice = contractInsert.getPriceAmount() * Integer.parseInt(contractInsert.getProductQuantity()) + couponBalance.getCouponBalance();
					System.out.println("===balance couponprice update====" + couponPrice);
					couponBalance.setCouponBalance(couponPrice);
				}
				
				//업데이트
				int couponBalanceUpdate = couponBalance.getCouponBalance();
				int updateCouponBalanceFlag = contractService.updateCouponBalanceWhenContarctInsert(couponBalance);
			}
			
			CouponUseHistory couponUseHistory = new CouponUseHistory();
			couponUseHistory.setCustomerNumber(contractInsert.getCustomerNumber());
			couponUseHistory.setProvidernumber(contractInsert.getProvidernumber());
			couponUseHistory.setCouponType(contractInsert.getProductType());
			couponUseHistory.setCouponUseType("REGIST");
			couponUseHistory.setUseHistory("쿠폰등록");
			
			if(couponUseHistory.getCouponType().equals("COUPONCOUNT"))
			{
				System.out.println("===history couponcount insert===="+ Integer.parseInt(contractInsert.getProductQuantity()));
				couponUseHistory.setUseAmount(Integer.parseInt(contractInsert.getProductQuantity()));
			}
			else
			{
				int couponPrice = contractInsert.getPriceAmount() * Integer.parseInt(contractInsert.getProductQuantity());
				System.out.println("===history couponprice insert===="+ couponPrice);
				couponUseHistory.setUseAmount(couponPrice);
			}
			
			int createCouponUseHistory = contractService.createCouponUseHIstoryWhenConatractInsert(couponUseHistory);
		}
		 
		 
		 System.out.println("선납여부"+ contractInsert.getRecurringInvoiceYn());
		 
		 PaymentPrePayInvoiceInput paymentprepayinvoiceinput = new PaymentPrePayInvoiceInput();
		 
		 if(contractInsert.getRecurringInvoiceYn().equals("N")) {
			 
			 System.out.println("=====선납프로세스 시작 api 호출=====");
			  int result = 0;
			  //contractInsert.setSuspenddatetime("20180913");
			  
			  ContractInsert contractSubscribeDateTime = contractService.findSubscribeDateTime(contractInsert.getConNumber());
			  			  			  
			  
			  System.out.println("===================setCalculationPrepay=====================");
			  System.out.println("connumber = " + contractInsert.getConNumber());
			  System.out.println("calfromdate = " + contractSubscribeDateTime.getSubscribeDateTime());
			  
			  InvoiceCreatePrePayInvoiceInput invoicecreateprepayinvoiceinput = new InvoiceCreatePrePayInvoiceInput();
			  invoicecreateprepayinvoiceinput.setConnumber(contractInsert.getConNumber());
			  invoicecreateprepayinvoiceinput.setCalfromDate(contractSubscribeDateTime.getSubscribeDateTime());
			  invoicecreateprepayinvoiceinput.setProvidernumber(user.getProvidernumber());
			  invoicecreateprepayinvoiceinput.setUsername(user.getUsername());
			  
			  System.out.println("connumber2 = " + invoicecreateprepayinvoiceinput.getConnumber());
			  System.out.println("calfromdate2 = " + invoicecreateprepayinvoiceinput.getCalfromDate());
			  
			  result = insertInvoiceCalculationPrePay(invoicecreateprepayinvoiceinput);
			  result = insertInvoiceCalculationPrePayDiscount(invoicecreateprepayinvoiceinput);
			  result = insertInvoiceDetailPrePay(invoicecreateprepayinvoiceinput);
			  paymentprepayinvoiceinput = insertInvoicePrePay(invoicecreateprepayinvoiceinput);
			  System.out.println("===================endCalculationPrepay=====================");
			  			  
			 //System.out.println("======api 호출 끝====" + paymentprepayinvoiceinput.getInvoicenumber());
			 //System.out.println("======api 호출 끝====" + paymentprepayinvoiceinput.getInvoicedate());
			 //System.out.println("======api 호출 끝====" + paymentprepayinvoiceinput.getConnumber());
			 
			 //팝업 호출			 
		 }		 
		 
		 return paymentprepayinvoiceinput;
		 
	 }
	 
	 public int insertInvoiceCalculationPrePay(InvoiceCreatePrePayInvoiceInput idi) {
		   int result = 0 ;
		   
		   result = invoiceService.setInvoiceCalculationPrepay(idi);
		   if(result == 0) {
		    return result; 
		   }
		   return result; 
		  }
		    
		  public int insertInvoiceCalculationPrePayDiscount(InvoiceCreatePrePayInvoiceInput idi) {
		   int result = 0 ;
		   result += invoiceService.setInvoiceCalculationDiscountRatePrepay(idi);
		   result += invoiceService.setInvoiceCalculationDiscountAmountPrepay(idi);
		   result += invoiceService.setInvoiceCalculationDiscountOneTimeFeePrepay(idi);
		   System.out.println("===================insertInvoiceCalculationPrePayDiscount=====================");
		   return result; 
		  }
		  
		  public int insertInvoiceDetailPrePay(InvoiceCreatePrePayInvoiceInput idi) {
		   int result = 0 ;
		   result += invoiceService.setInvoiceDetailPrepay(idi);
		   result += invoiceService.updateInvoiceDetailPrepay(idi);
		   result += invoiceService.updateInvoiceCalculationPrepay(idi);
		   System.out.println("===================insertInvoiceDetailPrePay=====================");
		   return result; 
		  }
		  
		  public PaymentPrePayInvoiceInput insertInvoicePrePay(InvoiceCreatePrePayInvoiceInput idi) {
		   int result = 0 ;
		   PaymentPrePayInvoiceInput paymentprepayinvoiceinput = new PaymentPrePayInvoiceInput();
		   result += invoiceService.setInvoicePrepay(idi);
		   paymentprepayinvoiceinput = invoiceService.getPrePayInvoice(idi);
		   System.out.println("===================insertInvoicePrePay=====================");
		   return paymentprepayinvoiceinput; 
		  }
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/batchproductsale", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewbatchProductSale() {
			System.out.println("____________________viewProductSale____________________");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/batchproductsale");
			return modelAndView;
	}
	 
	 @RequestMapping(value = "/productsale/batchproductsale", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewbatchProductSale2() {
			System.out.println("____________________viewProductSale2____________________");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/batchproductsale");
			return modelAndView;
	}
	 
	 
		 
	 @RequestMapping(value = "/batchcontract", method = RequestMethod.POST)
		public void saveBatchContract(@ModelAttribute BatchContract batchContract, Model model, Principal principal) {
			System.out.println("____________________saveBatchContract____________________");
			
			int customerNumber = 0;
			
			Customer customer = new Customer();
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			customer.setProvidernumber(user.getProvidernumber());
			customer.setUsername(user.getUsername());
			/*ID mapping*/
			customer.setCustomerName(batchContract.getCustomerName());
			customer.setBirthday(batchContract.getBirthday());
			customer.setPhoneNumber(batchContract.getPhoneNumber());
			
			if (customerService.findCustomerByCustomerNameAndBirthdayAndPhoneNumber(customer) != null) {
				customer = customerService.findCustomerByCustomerNameAndBirthdayAndPhoneNumber(customer);
			} 
			
			System.out.println("customer.getCustomerNumber() = " + customer.getCustomerNumber());
			
			if (customer.getCustomerNumber() == 0) {
				Address address = customerService.findAddressId();
				address.setZipcode(batchContract.getZipcode());
				address.setBaseAddress(batchContract.getBaseAddress());
				address.setDetailAddress(batchContract.getDetailAddress());
				customerService.saveAddress(address);
				
				System.out.println("address.getAddressId() = " + address.getAddressId());
				System.out.println("batchContract.getZipcode() = " + batchContract.getZipcode());
				System.out.println("batchContract.getBaseAddress() = " + batchContract.getBaseAddress());
				System.out.println("batchContract.getDetailAddress() = " + batchContract.getDetailAddress());
				
				//customer.setProvidernumber(batchContract.getProviderNumber());
				customer.setSex(batchContract.getSex());
				customer.setEmail(batchContract.getEmail());
				customer.setAddressId(address.getAddressId());
				customer.setDeliveryAddressId(address.getAddressId());
				customer.setCustomerType(batchContract.getCustomerType());
				customer.setCreateDate(batchContract.getCreateDate());
				customer.setCurrentDate(batchContract.getCurrentDate());
				customerService.saveCustomer(customer);
				customerNumber = customer.getCustomerNumber();
				
				System.out.println("batchContract.getCustomerNumber() = " + batchContract.getCustomerNumber());
				System.out.println("batchContract.getCustomerName() = " + batchContract.getCustomerName());
				System.out.println("batchContract.getSex() = " + batchContract.getSex());
				System.out.println("batchContract.getEmail() = " + batchContract.getEmail());
			} else {
				customerNumber = customer.getCustomerNumber();
			}
			
			ContractInsert contractInsert = new ContractInsert();
			/*ID mapping*/
			contractInsert.setProvidernumber(user.getProvidernumber());
			contractInsert.setUsername(user.getUsername());
			/*ID mapping*/
			contractInsert.setCustomerNumber(customerNumber);
			contractInsert.setPaymentMethod(batchContract.getPaymentMethod());
			contractInsert.setDeliveryAddressId(customer.getAddressId());
			contractInsert.setInvoiceDeliveryType(batchContract.getInvoiceDeliveryType());
			contractInsert.setInvoiceEmail(batchContract.getInvoiceEmail());
			int paymentInfoInsertReturn = contractService.paymentInfoInsert(contractInsert);
			int paymentInformationNumber = contractInsert.getPaymentInformationNumber();
			
			System.out.println("customerNumber = " + customer.getCustomerNumber());
			System.out.println("batchContract.getPaymentMethod() = " + batchContract.getPaymentMethod());
			System.out.println("batchContract.batchContract.getInvoiceDeliveryType() = " + batchContract.getInvoiceDeliveryType());
			System.out.println("batchContract.getInvoiceEmail() = " + batchContract.getInvoiceEmail());
			
		
			contractInsert.setCustomerNumber(customerNumber);
			contractInsert.setPaymentInformationNumber(paymentInformationNumber);
			contractInsert.setEffectStartDateTime(batchContract.getEffectStartDateTime());
			contractInsert.setEffectEndDateTime(batchContract.getEffectEndDateTime());
			contractInsert.setDeliveryCycle(batchContract.getDeliveryCycle());
			contractInsert.setDeliveryTimes(batchContract.getDeliveryTimes());
			contractInsert.setDeliveryRemark(batchContract.getDeliveryRemark());
			contractInsert.setDeliveryStartDatetime(batchContract.getDeliveryStartDatetime());
			contractInsert.setDeliveryTotalCount(batchContract.getDeliveryTotalCount());
			contractInsert.setDeliveryRemainCount(batchContract.getDeliveryRemainCount());
			contractInsert.setInvoiceCycle(batchContract.getInvoiceCycle());
			int createContractReturn = contractService.createContract(contractInsert);
					
			System.out.println("paymentInformationNumber = " + contractInsert.getPaymentInformationNumber());
			System.out.println("batchContract.getEffectStartDateTime() = " + batchContract.getEffectStartDateTime());
			System.out.println("batchContract.getEffectEndDateTime() = " + batchContract.getEffectEndDateTime());
			System.out.println("batchContract.getDeliveryCycle() = " + batchContract.getDeliveryCycle());
			System.out.println("batchContract.getDeliveryTimes() = " + batchContract.getDeliveryTimes());
			System.out.println("batchContract.getDeliveryRemark() = " + batchContract.getDeliveryRemark());
			System.out.println("batchContract.getDeliveryStartDatetime() = " + batchContract.getDeliveryStartDatetime());
			System.out.println("batchContract.getDeliveryTotalCount() = " + batchContract.getDeliveryTotalCount());
			System.out.println("batchContract.getDeliveryRemainCount() = " + batchContract.getDeliveryRemainCount());
			System.out.println("batchContract.getInvoiceCycle() = " + batchContract.getInvoiceCycle());
			
			Product3 product = new Product3();
			/*ID mapping*/
			product.setProvidernumber(user.getProvidernumber());
			product.setUsername(user.getUsername());
			/*ID mapping*/
			product.setProductId(batchContract.getProductId());
			product = productService.findProductByProductId(product);
			ProductPackage productPackage = new ProductPackage();
			productPackage.setMainProductId(batchContract.getProductId());
			productPackage = productService.findProductPackageByMainProductId(productPackage);
			contractInsert.setProductId(batchContract.getProductId());
			contractInsert.setProductType(product.getProductType());
			contractInsert.setPackageId(productPackage.getPackageId());
			contractInsert.setPackagePriceReferenceYn(product.getPackagePriceReferenceYn());
			contractInsert.setPackageVarietyYn(product.getPackageVarietyYn());
			contractInsert.setProductQuantity(batchContract.getProductQuantity());
			int createContractProductReturn = contractService.createContractProduct(contractInsert);

			System.out.println("conNumber = " + contractInsert.getConNumber());
			System.out.println("batchContract.getProductId() = " + batchContract.getProductId());		
			System.out.println("batchContract.getProductQuantity() = " + batchContract.getProductQuantity());
			System.out.println("product.getProductType() = " + product.getProductType());
			System.out.println("productPackage.getPackageId() = " + productPackage.getPackageId());
			System.out.println("product.getPackagePriceReferenceYn() = " + product.getPackagePriceReferenceYn());
			System.out.println("product.getPackageVarietyYn() = " + product.getPackageVarietyYn());
			System.out.println("productPackage.getPackageId() = " + productPackage.getPackageId());

			Discount discount = new Discount();
			
			discount.setDiscountId(batchContract.getDiscountId());
			discount = productService.findDiscountByDiscountId(discount);
			/*ID mapping*/
			discount.setProvidernumber(user.getProvidernumber());
			discount.setUsername(user.getUsername());
			/*ID mapping*/
			contractInsert.setDiscountId(batchContract.getDiscountId());
			contractInsert.setDiscountType(discount.getDiscountType());
			contractInsert.setDiscountValue(discount.getDiscountValue());
			contractInsert.setDiscountOrder(discount.getDiscountOrder());
			contractInsert.setEffectStartDateTime(batchContract.getContractDiscountEffectStartDateTime());
			contractInsert.setEffectEndDateTime(batchContract.getContractDiscountEffectEndDateTime());
			int createContractDiscountReturn = contractService.createContractDiscount(contractInsert);

			System.out.println("batchContract.getDiscountId() = " + batchContract.getDiscountId());
			System.out.println("batchContract.getContractDiscountEffectStartDateTime() = " + batchContract.getContractDiscountEffectStartDateTime());
			System.out.println("batchContract.getContractDiscountEffectEndDateTime() = " + batchContract.getContractDiscountEffectEndDateTime());
			System.out.println("discount.getDiscountType() = " + discount.getDiscountType());
			System.out.println("discount.getDiscountValue() = " + discount.getDiscountValue());
			System.out.println("discount.getDiscountOrder() = " + discount.getDiscountOrder());
			System.out.println("createContractDiscountReturn = " + createContractDiscountReturn);
			
			return;
		}
	 
		@RequestMapping(value = "/customersearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewCustomerSearch(Model model) {
			System.out.println("____________________viewCustomerSearch____________________");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/customersearch");
			return modelAndView;
		}
		
		@RequestMapping(value = "/customerlistsearch", method = RequestMethod.GET)
		public Map<String, Object> findAll(@ModelAttribute Customer customer, Model model, Principal principal) {
			System.out.println("____________________findAll____________________");
			Map<String, Object> map = new HashMap<>();
			Criteria cri = customer;
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			customer.setProvidernumber(user.getProvidernumber());
			customer.setUsername(user.getUsername());
			/*ID mapping*/
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(customerService.findAllTotalCount(user.getProvidernumber()));
			map.put("lists", customerService.findAll(pageMaker.getCri().getPageStart(), cri.getPerPageNum(),user.getProvidernumber())); // 리스트fetch
			System.out.println("pageMaker.getCri().getPageStart() = " + pageMaker.getCri().getPageStart());
			System.out.println("cri.getPerPageNum() = " + cri.getPerPageNum());
			System.out.println("pageMaker.getTotalCount() = " + pageMaker.getTotalCount());
			map.put("pageMaker", pageMaker); 
			return map;
		}
		
		@RequestMapping(value = "/customersearchbar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewCustomerSearchBar(Model model) {
			System.out.println("____________________viewCustomerSearchBar____________________");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/customersearchbar");
			return modelAndView;
		}
		
		@RequestMapping(value="/productlist/{customernumber}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewProductList(@PathVariable(value = "customernumber") int customerNumber) {
			// TODO Auto-generated method stub
			System.out.println("____________________viewProductList____________________");
			List<Product> product = customerService.findProductByCustomerNumber(customerNumber);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/productlist");
			modelAndView.addObject("productListResult", product);
			return modelAndView;
		}
		
		 @RequestMapping(value = "/findcustomersearchbar", method = RequestMethod.GET)
		 public Map<String, Object> findCustomerByCustomerSearchBar(@ModelAttribute CustomerSearchBar customerSearchBar, Model model, Principal principal) {
			System.out.println("____________________findCustomerByCustomerSearchBar____________________");
			Map<String, Object> map = new HashMap<>();
			System.out.println("customerSearchBar.getCustomerName() = " + customerSearchBar.getCustomerName());
			System.out.println("customerSearchBar.getPhoneNumber() = " + customerSearchBar.getPhoneNumber());
			Criteria cri = customerSearchBar;
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			customerSearchBar.setProvidernumber(user.getProvidernumber());
			customerSearchBar.setUsername(user.getUsername());
			/*ID mapping*/
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(customerService.findCustomerBySearchBarTotalCount(customerSearchBar));
			System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
			map.put("lists", customerService.findCustomerBySearchBar(customerSearchBar)); // 리스트fetch
			map.put("pageMaker", pageMaker); 
			return map;
		 }
		
		@RequestMapping(value = "/customerupdate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewCustomerUpdate(Model model) {
			System.out.println("____________________viewCustomerUpdate____________________");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/customerupdatetemplate");
			return modelAndView;
		}
		
		@RequestMapping(value = "/customerupdate/{customernumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewCustomerUpdateByCustomerNumber(@PathVariable(value = "customernumber") int customerNumber) {
			System.out.println("____________________viewCustomerUpdateByCustomerNumber____________________");
			Customer customer = customerService.findCustomerByCustomerNumber(customerNumber);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/customerupdate");
			modelAndView.addObject("customerResult", customer);
			return modelAndView;
		}

		@RequestMapping(value = "/findAddressId", method = RequestMethod.GET)
		public ModelAndView findAddressId(Model model, Principal principal) {
			System.out.println("____________________findAddressId____________________");
			Address address = customerService.findAddressId();
			System.out.println("addressId = " + address.getAddressId());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/customeraddress");
			modelAndView.addObject("addressResult", address);
			return modelAndView;
		}
		
		@RequestMapping(value = "/findAddressIdPopUp", method = RequestMethod.GET)
		public ModelAndView findAddressIdPopUp(Model model, Principal principal) {
			System.out.println("____________________findAddressIdPopUp____________________");
			Address address = customerService.findAddressId();
			System.out.println("addressId = " + address.getAddressId());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/customeraddresspopup");
			modelAndView.addObject("addressResult", address);
			return modelAndView;
		}
		
		@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
		public void saveAddress(@ModelAttribute Address address, Model model, Principal principal) {
			System.out.println("____________________saveAddress____________________");
			
			System.out.println("addressId = " + address.getAddressId());
			System.out.println("zipcode = " + address.getZipcode());
			System.out.println("baseAddress = " + address.getBaseAddress());
			System.out.println("detailAddress = " + address.getDetailAddress());
			customerService.saveAddress(address);
			return;
		}
		
		@RequestMapping(value = "/saveAddressUpdate", method = RequestMethod.POST)
		public void saveAddressUpdate(@ModelAttribute Address address, Model model, Principal principal) {
			System.out.println("____________________saveAddressUpdate____________________");
			System.out.println("addressId = " + address.getAddressId());
			System.out.println("zipcode = " + address.getZipcode());
			System.out.println("baseAddress = " + address.getBaseAddress());
			System.out.println("detailAddress = " + address.getDetailAddress());
			customerService.saveAddressUpdate(address);
			return;
		}
		
		@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
		public void saveCustomer(@ModelAttribute Customer customer, Model model, Principal principal) {
			System.out.println("____________________saveCustomer____________________");	
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			customer.setProvidernumber(user.getProvidernumber());
			customer.setUsername(user.getUsername());
			/*ID mapping*/
			System.out.println("customerName = " + customer.getCustomerName());
			System.out.println("birthday = " + customer.getBirthday());
			System.out.println("email = " + customer.getEmail());
			System.out.println("phoneNumber = " + customer.getPhoneNumber());
			System.out.println("addressId = " + customer.getAddressId());
		    customerService.saveCustomer(customer);
			return;
		}
		
		@RequestMapping(value = "/saveCustomerUpdate", method = RequestMethod.POST)
		public void saveCustomerUpdate(@ModelAttribute Customer customer, Model model, Principal principal) {
			System.out.println("____________________saveCustomerUpdate____________________");		
			System.out.println("customerNumber = " + customer.getCustomerNumber());
			System.out.println("customerName = " + customer.getCustomerName());
			System.out.println("birthday = " + customer.getBirthday());
			System.out.println("email = " + customer.getEmail());
			System.out.println("phoneNumber = " + customer.getPhoneNumber());
			System.out.println("addressId = " + customer.getAddressId());
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			customer.setProvidernumber(user.getProvidernumber());
			customer.setUsername(user.getUsername());
			/*ID mapping*/
			customerService.saveCustomerUpdate(customer);
			return;
		}
		
		@RequestMapping(value="/counsellinginformation/{customernumber}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewCounsellingList(@PathVariable(value = "customernumber") int customerNumber) {
			// TODO Auto-generated method stub
			System.out.println("____________________viewviewCounsellingList____________________");
			List<CounsellingHistory> counsellingHistory = customerService.findCounsellingHistorySummaryByCustomerNumber(customerNumber);
			//System.out.println("counsellingHistory.getCustomerNumber = " + counsellingHistory.iterator().next().getCustomerNumber());
			CustomerCharacteristic customerCharacteristic = customerService.findCustomerCharacteristicByCustomerNumber(customerNumber);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/counsellinginformation");
			modelAndView.addObject("counsellingHistoryListResult", counsellingHistory);
			modelAndView.addObject("customerCharacteristicResult", customerCharacteristic);
			return modelAndView;
		}
		
		  @RequestMapping(value = "/customercounselling/{customernumber}", method = RequestMethod.GET)
		  public ModelAndView viewCustomerCounselling(@PathVariable(value = "customernumber") int customerNumber) {
		   System.out.println("____________________viewCustomerCounselling____________________");
		   Customer customer = customerService.findCustomerByCustomerNumber(customerNumber);
		   CustomerCharacteristic customerCharacteristic = customerService.findCustomerCharacteristicByCustomerNumber(customerNumber);
		   List<CounsellingHistory> counsellingHistory = customerService.findCounsellingHistoryByCustomerNumber(customerNumber);
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.setViewName("popup/customercounselling");
		   modelAndView.addObject("customerResult", customer);
		   modelAndView.addObject("customerCharacteristicResult", customerCharacteristic);
		   modelAndView.addObject("counsellingHistoryListResult", counsellingHistory);  
		   return modelAndView;
		  }
		
		@RequestMapping(value = "/saveCustomerCharacteristic", method = RequestMethod.POST)
		public void saveCustomerCharacteristic(@ModelAttribute CustomerCharacteristic customerCharacteristic, Model model, Principal principal) {
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			customerCharacteristic.setProvidernumber(user.getProvidernumber());
			customerCharacteristic.setUsername(user.getUsername());
			/*ID mapping*/
			System.out.println("____________________saveCustomerCharacteristic____________________");
			System.out.println("customerCharacteristic.customerNumber = " + customerCharacteristic.getCustomerNumber());
			System.out.println("customerCharacteristic.characteristic = " + customerCharacteristic.getCharacteristic());
			System.out.println("customerCharacteristic.memo = " + customerCharacteristic.getMemo());
			customerService.saveCustomerCharacteristic(customerCharacteristic);
			return;
		}
		
		@RequestMapping(value = "/saveCounsellingHistory", method = RequestMethod.POST)
		public void saveCounsellingHistory(@ModelAttribute CounsellingHistory counsellingHistory, Model model, Principal principal) {
			System.out.println("____________________saveCounsellingHistory____________________");
			System.out.println("counsellingHistory.customerNumber = " + counsellingHistory.getCustomerNumber());
			System.out.println("counsellingHistory.category = " + counsellingHistory.getCategory());
			System.out.println("counsellingHistory.inboundPath = " + counsellingHistory.getInboundPath());
			System.out.println("counsellingHistory.memo = " + counsellingHistory.getMemo());
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			counsellingHistory.setProvidernumber(user.getProvidernumber());
			counsellingHistory.setUsername(user.getUsername());
			/*ID mapping*/
			customerService.saveCounsellingHistory(counsellingHistory);
			return;
		}	
		@RequestMapping(value = "/couponusesearchbar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewCouponUseSearchBar(Model model) {
			System.out.println("____________________viewCouponUseSearchBar____________________");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/couponusesearchbar");
			return modelAndView;
		}
	
		@RequestMapping(value = "/findcouponusesearchbar", method = RequestMethod.GET)
		public ModelAndView findCouponUseCustomerBySearchBar(@ModelAttribute CustomerSearchBar customerSearchBar, Model model,Principal principal) {
			System.out.println("____________________findCouponUseCustomerBySearchBar____________________");
			System.out.println("customerSearchBar.getCustomerName() = " + customerSearchBar.getCustomerName());
			System.out.println("customerSearchBar.getPhoneNumber() = " + customerSearchBar.getPhoneNumber());
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			customerSearchBar.setProvidernumber(user.getProvidernumber());
			customerSearchBar.setUsername(user.getUsername());
			/*ID mapping*/
			List<Customer> customer = contractService.findCustomerBySearchBar(customerSearchBar);
			ModelAndView modelAndView = new ModelAndView();
			System.out.println("customer.size() = " + customer.size());
			modelAndView.setViewName("popup/couponusecustomerlistpopup");
			modelAndView.addObject("customerListResult", customer);
			return modelAndView;
		}
		
		@RequestMapping(value = "/findcouponuse/{customernumber}", method = RequestMethod.GET)
		public ModelAndView viewCouponUse(@PathVariable(value = "customernumber") int customerNumber) {
			System.out.println("____________________viewCouponUse____________________");
			CouponBalance couponBalance = contractService.findCouponBalanceByCustomerNumber(customerNumber);
			List<CouponUseHistory> couponUseHistory = contractService.findCouponUseHistoryByCustomerNumber(customerNumber);
			
			System.out.println("couponBalance.getCouponType() = " + couponBalance.getCouponType());
			System.out.println("couponBalance.getCouponBalance() = " + couponBalance.getCouponBalance());
			
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/couponuse");
			modelAndView.addObject("couponBalanceResult", couponBalance);
			modelAndView.addObject("couponUseHistoryListResult", couponUseHistory);		
			return modelAndView;
		}
		
		@RequestMapping(value = "/saveCouponUseHistory", method = RequestMethod.POST)
		public void saveCouponUse(@ModelAttribute CouponUseHistory couponUseHistory
				, Model model
				, Principal principal) {
			System.out.println("____________________saveCouponUseHistory____________________");
			System.out.println("couponUseHistory.getCustomerNumber() = " + couponUseHistory.getCustomerNumber());
			System.out.println("couponUseHistory.getCouponType() = " + couponUseHistory.getCouponType());
			System.out.println("couponUseHistory.getUseAmount() = " + couponUseHistory.getUseAmount());
			System.out.println("couponUseHistory.getUseHistory() = " + couponUseHistory.getUseHistory());
			/*ID mapping*/
			User user = userService.readUser(principal.getName());
			couponUseHistory.setProvidernumber(user.getProvidernumber());
			couponUseHistory.setUsername(user.getUsername());
			/*ID mapping*/
			contractService.saveCouponUseHistory(couponUseHistory);
			
			CouponBalance couponBalance = new CouponBalance();
			couponBalance.setProvidernumber(user.getProvidernumber());
			couponBalance.setUsername(user.getUsername());
			couponBalance.setCustomerNumber(couponUseHistory.getCustomerNumber());
			couponBalance.setCouponType(couponUseHistory.getCouponType());
			couponBalance.setCouponBalance(couponUseHistory.getUseAmount());
			contractService.saveCouponBalance(couponBalance);
			return;
		}
		
		@RequestMapping(value = "/couponusetemplate", method = RequestMethod.GET)
		public ModelAndView viewCouponUseTemplate() {
			System.out.println("____________________viewCouponUseTemplate____________________");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/contract/couponusetemplate");
			return modelAndView;
		}
	 
}
