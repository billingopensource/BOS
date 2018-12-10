package com.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.api.billing.model.contract.Product;
import com.api.billing.model.customer.Address;
import com.api.billing.model.customer.CounsellingHistory;
import com.api.billing.model.customer.Customer;
import com.api.billing.model.customer.CustomerCharacteristic;
import com.api.billing.model.customer.CustomerSearchBar;

@Mapper
@Repository
public interface CustomerRepository {

	List<Customer> findAll(int pageStart, int perPageNum,int providernumber); 
	
	int findAllTotalCount(int providernumber);
	
	List<Customer> findCustomerByCustomerName(String customerName);
	
	List<Customer> findCustomerByPhoneNumber(String phoneNumber);
	
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
