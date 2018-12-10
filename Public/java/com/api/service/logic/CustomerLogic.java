package com.api.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.billing.model.contract.Product;
import com.api.billing.model.customer.Address;
import com.api.billing.model.customer.CounsellingHistory;
import com.api.billing.model.customer.Customer;
import com.api.billing.model.customer.CustomerCharacteristic;
import com.api.billing.model.customer.CustomerSearchBar;
import com.api.repository.CustomerRepository;
import com.api.service.CustomerService;

@Service
@Transactional
public class CustomerLogic implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll(int pageStart, int perPageNum,int providernumber) {
		// TODO Auto-generated method stub
		List<Customer> customer = customerRepository.findAll(pageStart, perPageNum,providernumber);
		return customer;
	}
	
	@Override
	public int findAllTotalCount(int providernumber) {
		// TODO Auto-generated method stub
		return customerRepository.findAllTotalCount(providernumber);
	}

	@Override
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findCustomerByCustomerNumber(customerNumber);
		return customer;
	}

	@Override
	public List<Product> findProductByCustomerNumber(int customerNumber) {
		// TODO Auto-generated method stub
		List<Product> product = customerRepository.findProductByCustomerNumber(customerNumber);
		return product;
	}

	@Override
	public List<Customer> findCustomerBySearchBar(CustomerSearchBar customerSearchBar) {
		// TODO Auto-generated method stub
		List<Customer> customer = customerRepository.findCustomerBySearchBar(customerSearchBar);
		return customer;
	}

	@Override
	public int findCustomerBySearchBarTotalCount(CustomerSearchBar customerSearchBar) {
		// TODO Auto-generated method stub
		int customerCount = customerRepository.findCustomerBySearchBarTotalCount(customerSearchBar);
		return customerCount;
	}
	
	@Override
	public Address findAddressId() {
		// TODO Auto-generated method stub
		Address address = customerRepository.findAddressId();
		return address;
	}

	@Override
	public void saveAddress(Address address) {
		// TODO Auto-generated method stub
		customerRepository.saveAddress(address);
		return;
	}

	@Override
	public void saveAddressUpdate(Address address) {
		// TODO Auto-generated method stub
		customerRepository.saveAddressUpdate(address);
		return;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.saveCustomer(customer);
		return;
	}

	@Override
	public void saveCustomerUpdate(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.saveCustomerUpdate(customer);
		return;
	}

	@Override
	public List<CounsellingHistory> findCounsellingHistorySummaryByCustomerNumber(int customerNumber) {
		// TODO Auto-generated method stub
		List<CounsellingHistory> counsellingHistory = customerRepository.findCounsellingHistorySummaryByCustomerNumber(customerNumber);
		return counsellingHistory;
	}
	
	@Override
	public List<CounsellingHistory> findCounsellingHistoryByCustomerNumber(int customerNumber) {
		// TODO Auto-generated method stub
		List<CounsellingHistory> counsellingHistory = customerRepository.findCounsellingHistoryByCustomerNumber(customerNumber);
		return counsellingHistory;
	}

	@Override
	public CustomerCharacteristic findCustomerCharacteristicByCustomerNumber(int customerNumber) {
		// TODO Auto-generated method stub
		CustomerCharacteristic customerCharacteristic = customerRepository.findCustomerCharacteristicByCustomerNumber(customerNumber);
		return customerCharacteristic;
	}

	@Override
	public void saveCustomerCharacteristic(CustomerCharacteristic customerCharacteristic) {
		// TODO Auto-generated method stub
		customerRepository.saveCustomerCharacteristic(customerCharacteristic);
	}

	@Override
	public void saveCounsellingHistory(CounsellingHistory counsellingHistory) {
		// TODO Auto-generated method stub
		customerRepository.saveCounsellingHistory(counsellingHistory);
	}
	
	@Override
	public Customer findCustomerByCustomerNameAndBirthdayAndPhoneNumber(Customer customer) {
		// TODO Auto-generated method stub
		customer = customerRepository.findCustomerByCustomerNameAndBirthdayAndPhoneNumber(customer);
		return customer;
	}
}
