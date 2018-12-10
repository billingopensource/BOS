package com.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.api.billing.invoice.model.Invoice;
import com.api.billing.invoice.model.InvoiceDateInput;
import com.api.billing.invoice.model.PaymentHistoryInput;
import com.api.billing.model.delivery.Delivery;
import com.api.billing.model.delivery.DeliveryDateInput;
import com.api.billing.model.delivery.DeliveryDetail;
import com.api.billing.model.delivery.DeliveryPackageInput;
import com.api.billing.model.product.Product3;

@Mapper
@Repository
public interface DeliveryRepository 
{
	List<Delivery> getDeliveryByDate(DeliveryDateInput idi);
	
	List<Package> getPackage(DeliveryPackageInput idi);

	int insertDeliveryDetail(PaymentHistoryInput idi);
	
	
	/*paging cnt */
	int getDeliveryTotCount(DeliveryDateInput idi);

	int getPackageTotalCount(DeliveryPackageInput idi);
	

}
