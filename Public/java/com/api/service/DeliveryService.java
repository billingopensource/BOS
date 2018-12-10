package com.api.service;

import java.util.List;

import com.api.billing.invoice.model.InvoiceDateInput;
import com.api.billing.invoice.model.PaymentHistoryInput;
import com.api.billing.model.delivery.Delivery;
import com.api.billing.model.delivery.DeliveryDateInput;
import com.api.billing.model.delivery.DeliveryDetail;
import com.api.billing.model.delivery.DeliveryPackageInput;

public interface DeliveryService 
{
	List<Delivery> getDeliveryByDate(DeliveryDateInput idi);
	
	List<Package> getPackageData(DeliveryPackageInput idi);
	
	int insertDeliveryDetail(PaymentHistoryInput idi);
	
	/*paging cnt */
	int getDeliveryTotCount(DeliveryDateInput idi);

	int getPackageTotalCount(DeliveryPackageInput idi);

}
