package com.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

@Mapper
@Repository
public interface ContractRepository {

	Customer findCustomerByCustomerNumber(int customerNumber);
	
	List<Contract> findContractByCustomerNumber(int customerNumber);
	
	PaymentInformation findPaymentInformationByConNumber(int conNumber);
	
	List<Customer> findCustomerBySearchBar(CustomerSearchBar customerSearchBar);
	
	List<Product3> findAllProduct();

	List<Discount> findAllDiscount();

	//추가
		List<Customer> getFindCustomerList(int customerList);
		
		List<Product2> getProductList(Product2 product);
		
		List<Discount> getDiscountList(DiscountEffectDate discountEffectDate);
		
		List<Discount2> findDiscountBySearchBar(DiscountSearchBar discountSearchBar);
		
		List<Discount2> getFindApplyDiscount(DiscountEffectDate discountEffectDate);
		
		int createDeliveryAddress(ContractInsert contractInsert);
		
		Address findDeliverAddressId(ContractInsert contractInsert);
		
		int paymentInfoInsert(ContractInsert contractInsert);
		
		int createContract(ContractInsert contractInsert);
		
		int createContractProduct(ContractInsert contractInsert);
		
		int createContractDiscount(ContractInsert contractInsert);
		
		ContractInsert findPackageId(ContractInsert contractInsert);
		
		ContractInsert findSubscribeDateTime(int conNumber);
		
		ContractProduct findContractProductByConNumberAndProductId(ContractProduct contractProduct);

		int findProductTotalCount();
		
		
		
		CouponBalance findCouponBalanceByCustomerNumber(int customerNumber);

		List<CouponUseHistory> findCouponUseHistoryByCustomerNumber(int customerNumber);

		void saveCouponUseHistory(CouponUseHistory couponUseHistory);

		void saveCouponBalance(CouponBalance couponBalance);
		
		//20180920
		CouponBalance findCouponBalanceWhenContractInsert(ContractInsert contractInsert);
		int createCouponBalanceWhenContractInsert(CouponBalance couponBalance);
		int updateCouponBalanceWhenContarctInsert(CouponBalance couponBalance);
		int createCouponUseHIstoryWhenConatractInsert(CouponUseHistory couponUseHistory);
}
