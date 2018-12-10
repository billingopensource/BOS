package com.api.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.billing.invoice.model.InvoiceDateInput;
import com.api.billing.login.model.User;
import com.api.report.model.ArticleInput;
import com.api.report.model.ArticleOutput;
import com.api.report.model.CustomerContractTotalOutput;
import com.api.report.model.InvoiceMonthlyOutput;
import com.api.report.model.InvoiceReportOutput;
import com.api.report.model.ProductRatioOutput;
import com.api.report.model.reportInput;
import com.api.service.ReportService;
import com.api.service.UserService;

@RestController
@RequestMapping(value = "report")
public class ReportController {

	@Autowired
	ReportService reportservice;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewSearchBar(HttpServletRequest request,Principal principal,Model model) {
		System.out.println("===================report-main=====================" );
		User user = userService.readUser(principal.getName());
		System.out.println("====="+user.getName());
        request.getSession(true).setAttribute("loginname", user.getName());
        request.getSession(true).setAttribute("businessname", user.getBusinessname());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/report/main");
		return modelAndView;
	 }
	
	@RequestMapping(value = "/writeNoticePopup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView writeNoticePopup(Model model) {
		System.out.println("===================writeNoticePopup=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("popup/writeNoticePopup");
		return modelAndView;
	 }
	
	@RequestMapping(value = "/getTotalCustomerandContract/{todaydate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public CustomerContractTotalOutput getTotalCustomerandContract(
			 @PathVariable(value = "todaydate") String todaydate
			 ,Model model
			 ,Principal principal) {
		/*ID mapping*/
		reportInput ri =  new reportInput();
		ri.setCalfromDate(todaydate);
		User user = userService.readUser(principal.getName());
		ri.setProvidernumber(user.getProvidernumber());
		ri.setUsername(user.getUsername());
		/*ID mapping*/
		System.out.println("===================getTotalCustomerandContract=====================");
		CustomerContractTotalOutput couptup = null;
		couptup = reportservice.getTotalCustomerandContract(ri);
		if(couptup == null) {
			return null;
		}
		System.out.println("couptup = " +  couptup.getTotal_contract_register());
		return couptup;
	 }
	
	@RequestMapping(value = "/getRatioProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public List<ProductRatioOutput> getRatioProduct(Model model,Principal principal) {
		System.out.println("===================getRatioProduct=====================");
		/*ID mapping*/
		reportInput ri =  new reportInput();
		User user = userService.readUser(principal.getName());
		ri.setProvidernumber(user.getProvidernumber());
		ri.setUsername(user.getUsername());
		/*ID mapping*/
		List<ProductRatioOutput> productratio = reportservice.getRatioProduct(ri);
		System.out.println("productratio = " +  productratio.size());
		return productratio;
	 }
	@RequestMapping(value = "/getRatioProductRank/{monthdate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public List<ProductRatioOutput> getRatioProductRank(
			 @PathVariable(value = "monthdate") String monthdate
			 ,Model model
			 ,Principal principal) {
		/*ID mapping*/
		reportInput ri =  new reportInput();
		ri.setCalfromDate(monthdate);
		User user = userService.readUser(principal.getName());
		ri.setProvidernumber(user.getProvidernumber());
		ri.setUsername(user.getUsername());
		/*ID mapping*/
		System.out.println("===================getRatioProductRank=====================");
		List<ProductRatioOutput> productratio = reportservice.getRatioProductRank(ri);
		System.out.println("productratio = " +  productratio.size());
		return productratio;
	 }
	
	@RequestMapping(value = "/getInvoiceReportOutput", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public InvoiceReportOutput getInvoiceReportOutput(Model model,Principal principal) {
		System.out.println("===================getRatioProductRank=====================");
		/*ID mapping*/
		reportInput ri =  new reportInput();
		User user = userService.readUser(principal.getName());
		ri.setProvidernumber(user.getProvidernumber());
		ri.setUsername(user.getUsername());
		/*ID mapping*/
		InvoiceReportOutput iro = reportservice.getInvoiceReportOutput(ri);
		return iro;
	 }
	
	@RequestMapping(value = "/getInvoiceReportMonthOutput", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public List<InvoiceMonthlyOutput> getInvoiceReportMonthOutput(Model model,Principal principal) {
		System.out.println("===================getInvoiceReportMonthOutput=====================");
		/*ID mapping*/
		reportInput ri =  new reportInput();
		User user = userService.readUser(principal.getName());
		ri.setProvidernumber(user.getProvidernumber());
		ri.setUsername(user.getUsername());
		/*ID mapping*/
		List<InvoiceMonthlyOutput> iro = reportservice.getInvoiceReportMonthOutput(ri);
		return iro;
	 }	
	/*article*/
	
	@RequestMapping(value = "/insertarticle", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public int insertArticle(
			 @ModelAttribute ArticleInput aci
			 ,Model model
			 ,Principal principal) {
		/*ID mapping*/
		reportInput ri =  new reportInput();
		User user = userService.readUser(principal.getName());
		aci.setProvidernumber(user.getProvidernumber());
		aci.setUsername(user.getUsername());
		/*ID mapping*/
		System.out.println("===================insertArticle=====================");
		int result = reportservice.insertArticle(aci);
		return result;
	 }
	
	@RequestMapping(value = "/getArticle", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ArticleOutput> getArticle(Model model,Principal principal) {
		System.out.println("===================getArticle=====================");
		/*ID mapping*/
		reportInput ri =  new reportInput();
		User user = userService.readUser(principal.getName());
		ri.setProvidernumber(user.getProvidernumber());
		ri.setUsername(user.getUsername());
		/*ID mapping*/
		List<ArticleOutput> result = reportservice.getArticle(ri);
		return result;
	 }
	
	@RequestMapping(value = "/updateArticle/{articlenum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public int deleteArticle(
			@PathVariable(value = "articlenum") int articlenum
			,Model model
			,Principal principal) {
		System.out.println("===================deleteArticle=====================");
		int result = reportservice.updateArticle(articlenum);
		return result;
	 }
	
	
	@RequestMapping(value = "/progressbar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewprogressbar(Model model) {
		System.out.println("===================viewprogressbar=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("roundprogressbar");
		return modelAndView;
	 }
	
}
