package com.api.service;

import java.util.List;

import com.api.billing.model.contract.Product;
import com.api.billing.model.customer.Address;
import com.api.billing.model.customer.CounsellingHistory;
import com.api.billing.model.customer.Customer;
import com.api.billing.model.customer.CustomerCharacteristic;
import com.api.billing.model.customer.CustomerSearchBar;

public interface CustomerService {
	
	List<Customer> findAll(int pageStart, int perPageNum,int providernumber); // pagination
	
	int findAllTotalCount(int providernumber);
	
	Customer findCustomerByCustomerNumber(int customerNumber);
	
	List<Product> findProductByCustomerNumber(int customerNumber);
	
	List<Customer> findCustomerBySearchBar(CustomerSearchBar customerSearchBar);
	
	int findCustomerBySearchBarTotalCount(CustomerSearchBar customerSearchBar);
	
	Address findAddressId();
	
	void saveAddress(Address address);
	
	void saveAddressUpdate(Address address);
	
	void saveCustomer(Customer customer);
	
	void saveCustomerUpdate(Customer customer);
	
	List<CounsellingHistory> findCounsellingHistorySummaryByCustomerNumber(int customerNumber);
	
	List<CounsellingHistory> findCounsellingHistoryByCustomerNumber(int customerNumber);

	CustomerCharacteristic findCustomerCharacteristicByCustomerNumber(int customerNumber);

	void saveCustomerCharacteristic(CustomerCharacteristic customerCharacteristic);

	void saveCounsellingHistory(CounsellingHistory counsellingHistory);
	
	Customer findCustomerByCustomerNameAndBirthdayAndPhoneNumber(Customer customer);
		
}
