package com.api.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.api.billing.invoice.model.PaymentHistoryInput;
import com.api.service.InvoiceService;

//import static org.toilelibre.libe.curl.Curl.$;

public class SendCurl {
	 private String item_name;
	 private String quantity;
	 private String total_amount;
	 private String tax_free_amount;
	 private String vat_amount;
	 private String tid;
	 private int invoicenumber;
	 private String invoicedate;
	 private int connumber;
	 private int paymentamt;
	 
	 
	public SendCurl(String item_name
            ,String quantity
            ,String total_amount
            ,String tax_free_amount
            ,String vat_amount
            ,int invoicenumber
            ,String invoicedate
            ,int connumber
            ,int paymentamt) {
		//payKaKaoPay(item_name,quantity,total_amount,tax_free_amount,vat_amount);
		//System.out.println(callURL(""));
		this.item_name = item_name;
		this.quantity = quantity;
		this.total_amount = total_amount;
		this.tax_free_amount = tax_free_amount;
		this.vat_amount = vat_amount;
		this.invoicenumber = invoicenumber;
		this.invoicedate = invoicedate;
		this.connumber = connumber;
		this.paymentamt = paymentamt;
		
		
	}
	
	public String payKaKaoPay() 
	{
		RestTemplate restTemplate = new RestTemplate();
	    // 서버로 요청할 Body
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	    params.add("cid", "TC0ONETIME");
	    params.add("partner_order_id", "1001");
	    params.add("partner_user_id", "test@koitt.com");
	    params.add("item_name", item_name);
	    params.add("quantity", quantity);
	    params.add("total_amount", total_amount);
	    params.add("tax_free_amount",tax_free_amount);
	    params.add("vat_amount",vat_amount);
	    params.add("approval_url", "http://169.56.103.202:7777/billing/success?invoicedate="+ invoicedate + "&invoicenumber="+ invoicenumber + "&connumber="+ connumber + "&paymentamt="+ paymentamt); 
	    params.add("cancel_url", "http://169.56.103.202:7777/cancel");
	    params.add("fail_url", "http://169.56.103.202:7777/fail");
	
	    // 서버로 요청할 Header
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "KakaoAK " + "fc9c36bd7cb9b99c846f5692fb1760a6");
	    headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
	    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
	    String response = null;
		try {
			response = restTemplate.postForObject(new URI("https://kapi.kakao.com/v1/payment/ready"), request, String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		Object obj;
		JSONObject jsonObj = null;
		try {
			obj = parser.parse( response );
			jsonObj = (JSONObject) obj;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response);
		tid = (String) jsonObj.get("tid");
		System.out.println(tid);
		
		
		
	    return response;
	}
	
	public PaymentHistoryInput setTidvalue(PaymentHistoryInput paymenthistoryinput) {
		paymenthistoryinput.setTid(tid);
		
		return paymenthistoryinput;
	}
	

}