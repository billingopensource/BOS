package com.api.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.billing.model.contract.Contract;
import com.api.billing.model.contract.ContractInsert;
import com.api.billing.model.contract.ContractProduct;
import com.api.billing.model.contract.CouponBalance;
import com.api.billing.model.contract.CouponUseHistory;
import com.api.billing.model.contract.Discount2;
import com.api.billing.model.contract.DiscountEffectDate;
import com.api.billing.model.contract.PaymentInfoInsert;
import com.api.billing.model.contract.PaymentInformation;
import com.api.billing.model.contract.Product2;
import com.api.billing.model.customer.Address;
import com.api.billing.model.customer.Customer;
import com.api.billing.model.customer.CustomerSearchBar;
import com.api.billing.model.product.Discount;
import com.api.billing.model.product.DiscountSearchBar;
import com.api.billing.model.product.Product3;
import com.api.repository.ContractRepository;
import com.api.service.ContractService;

@Service
@Transactional
public class ContractLogic implements ContractService {

	@Autowired
	private ContractRepository contractRepository;

	@Override
	public Customer findCustomerByCustomerNumber(int customerNumber) {
		// TODO Auto-generated method stub
		Customer customer = contractRepository.findCustomerByCustomerNumber(customerNumber);
		return customer;
	}
	
	@Override
	public List<Contract> findContractByCustomerNumber(int customerNumber) {
		// TODO Auto-generated method stub
		List<Contract> contract = contractRepository.findContractByCustomerNumber(customerNumber);
		return contract;
	}

	@Override
	public PaymentInformation findPaymentInformationByConNumber(int conNumber) {
		// TODO Auto-generated method stub
		PaymentInformation paymentInformation = contractRepository.findPaymentInformationByConNumber(conNumber);
		return paymentInformation;
	}

	@Override
	public List<Customer> findCustomerBySearchBar(CustomerSearchBar customerSearchBar) {
		// TODO Auto-generated method stub
		List<Customer> customer = contractRepository.findCustomerBySearchBar(customerSearchBar);
		return customer;
	}
	
	@Override
	public List<Product3> findAllProduct() {
		// TODO Auto-generated method stub
		List<Product3> product = contractRepository.findAllProduct();
		return product;
	}

	@Override
	public List<Discount> findAllDiscount() {
		// TODO Auto-generated method stub
		List<Discount> discount = contractRepository.findAllDiscount();
		return discount;
	}
	
	//추가
		@Override
		public List<Customer> getFindCustomerList(int customerNumber) {
			List<Customer> customerList = contractRepository.getFindCustomerList(customerNumber);
			return customerList;
		}
		
		@Override
		public List<Product2> getProductList(Product2 product) {
			System.out.println("SERVICE BEAN ==========> 들어오나 ???");
			List<Product2> productList = contractRepository.getProductList(product);
			System.out.println("SERVICE BEAN ==========> 값을 가져오나 ???"+ productList);
			return productList;
		}
		
		@Override
		public List<Discount> getDiscountList(DiscountEffectDate discountEffectDate) {
			List<Discount> discountList = contractRepository.getDiscountList(discountEffectDate);
			return discountList;
		}
		
		@Override
		public int createDeliveryAddress(ContractInsert contractInsert) {
			int craateDeliveryAddress = contractRepository.createDeliveryAddress(contractInsert);
			return 0;
		}
		
		@Override
		public Address findDeliverAddressId(ContractInsert contractInsert) {
			Address address = contractRepository.findDeliverAddressId(contractInsert);
			return address;
		}
		
		@Override
		public int paymentInfoInsert(ContractInsert contractInsert) {
			int paymentInfoInsertFlag = contractRepository.paymentInfoInsert(contractInsert);
			return paymentInfoInsertFlag;
		}
		
		@Override
		public int createContract(ContractInsert contractInsert) {
			int createContractFlag = contractRepository.createContract(contractInsert);
			return createContractFlag;
		}
		@Override
		public int createContractDiscount(ContractInsert contractInsert) {
			int createContractDiscountFlag = contractRepository.createContractDiscount(contractInsert);
			return createContractDiscountFlag;
		}
		@Override
		public int createContractProduct(ContractInsert contractInsert) {
			int createContractProductFlag = contractRepository.createContractProduct(contractInsert);
			return createContractProductFlag;
		}
		@Override
		public ContractInsert findPackageId(ContractInsert contractInsert) {
			contractInsert = contractRepository.findPackageId(contractInsert);
			return contractInsert;
		}
		@Override
		public ContractProduct findContractProductByConNumberAndProductId(ContractProduct contractProduct) {
			contractProduct = contractRepository.findContractProductByConNumberAndProductId(contractProduct);
			return contractProduct;
		}
		@Override
		public int findProductTotalCount() {
			return contractRepository.findProductTotalCount();
		}
		@Override
		public List<Discount2> findDiscountBySearchBar(DiscountSearchBar discountSearchBar) {
			List<Discount2> discount = contractRepository.findDiscountBySearchBar(discountSearchBar);
			return discount;
		}
		@Override
		public List<Discount2> getFindApplyDiscount(DiscountEffectDate discountEffectDate) {
			List<Discount2> discount = contractRepository.getFindApplyDiscount(discountEffectDate);
			return discount;
		}
		@Override
		public ContractInsert findSubscribeDateTime(int conNumber) {
			ContractInsert contractSubscribeDateTime = contractRepository.findSubscribeDateTime(conNumber);
			return contractSubscribeDateTime;
		}
		
		
		@Override
		public CouponBalance findCouponBalanceByCustomerNumber(int customerNumber) {
			// TODO Auto-generated method stub
			CouponBalance couponBalance = contractRepository.findCouponBalanceByCustomerNumber(customerNumber);
			return couponBalance;
		}

		@Override
		public List<CouponUseHistory> findCouponUseHistoryByCustomerNumber(int customerNumber) {
			// TODO Auto-generated method stub
			List<CouponUseHistory> couponUseHistory = contractRepository.findCouponUseHistoryByCustomerNumber(customerNumber);
			return couponUseHistory;
		}

		@Override
		public void saveCouponUseHistory(CouponUseHistory couponUseHistory) {
			// TODO Auto-generated method stub
			contractRepository.saveCouponUseHistory(couponUseHistory);
			return;
		}

		@Override
		public void saveCouponBalance(CouponBalance couponBalance) {
			// TODO Auto-generated method stub
			contractRepository.saveCouponBalance(couponBalance);
			return;
		}
		
		//20180920
		@Override
		public int createCouponBalanceWhenContractInsert(CouponBalance couponBalance) {
			// TODO Auto-generated method stub
			return contractRepository.createCouponBalanceWhenContractInsert(couponBalance);
		}
		
		@Override
		public CouponBalance findCouponBalanceWhenContractInsert(ContractInsert contractInsert) {
			// TODO Auto-generated method stub
			CouponBalance couponBalance = contractRepository.findCouponBalanceWhenContractInsert(contractInsert);
			return couponBalance;
		}
		@Override
		public int updateCouponBalanceWhenContarctInsert(CouponBalance couponBalance) {
			// TODO Auto-generated method stub
			return contractRepository.updateCouponBalanceWhenContarctInsert(couponBalance);
		}
		@Override
		public int createCouponUseHIstoryWhenConatractInsert(CouponUseHistory couponUseHistory) {
			// TODO Auto-generated method stub
			return contractRepository.createCouponUseHIstoryWhenConatractInsert(couponUseHistory);
		}
}
