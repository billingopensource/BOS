package com.api.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.Principal;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.api.billing.invoice.model.InvoiceDetailInput;
import com.api.billing.login.model.User;
import com.api.service.UserService;
import com.api.service.logic.MailContentBuilder;

@Controller
public class CommonController {

	@Autowired
	private JavaMailSender sender;
	@Autowired
	private MailContentBuilder mcb;
	InvoiceDetailInput idi;
	
	@Autowired UserService userService;

	@RequestMapping(value ="/sendmail", method = RequestMethod.GET)
	@ResponseBody
	String getEmailSendinfo(
			@RequestParam("invoicenumber") int invoicenumber
			,@RequestParam("invoicedate") String invoicedate
			,@RequestParam("connumber") int connumber
			,@RequestParam("sendEmailAddress") String sendEmailAddress
			,Principal principal) { //sendEmailAddress
		System.out.println("====================getEmailSendinfo======================");
		idi = new InvoiceDetailInput(invoicenumber, invoicedate, connumber);
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		idi.setProvidernumber(user.getProvidernumber());
		idi.setUsername(user.getUsername());
		/*ID mapping*/
		try {
			sendEmail(sendEmailAddress);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}

	}
	
	@RequestMapping(value = {"/login" , "/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView login(Model model,final HttpSession session) {
		System.out.println("===================login=====================");
		//session.setAttribute(UserConfig, value);
	    //session.setAttribute(UserConfig.SESS_USER_ID, '1');
	    //session.setAttribute(UserConfig.SESS_USER_NAME, '2');
	    // expired in 10 minutes
	    //session.setMaxInactiveInterval(60 * 10);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	 }
	
	

	private void sendEmail(String sendEmailAddress) throws Exception {

		String txt = mcb.build(idi);
		System.out.println("Text = " + txt);
		System.out.println("sendEmailAddress = " + sendEmailAddress);
		File filetmp = File.createTempFile("tmp", "html");
		PrintWriter printWriter = new PrintWriter(filetmp);
		printWriter.println(txt);
		printWriter.close();
		//String m = idi.getInvoiceDate().substring(4, 2);
		//System.out.println("m = " + m);
	    
	    MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(sendEmailAddress);
		helper.setText("8월 청구서 입니다.");
		helper.setSubject("고객님 청구서입니다.");
		//ClassPathResource file = new ClassPathResource("tmp.html");
		//helper.addInline("id101", file);
		helper.addAttachment("청구서.html", filetmp);
		sender.send(message);

	}
	
	
	

}
