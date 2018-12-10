package com.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerInfoSetting {
	
	@Value("${customerName}")
    static String customerName;

	@Value("${customerName}")
	public static String getCustomerName() {
		return customerName;
	}

	public static void setCustomerName(String customerName) {
		CustomerInfoSetting.customerName = customerName;
	}

	
}
