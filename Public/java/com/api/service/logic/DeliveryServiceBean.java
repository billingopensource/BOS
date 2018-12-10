package com.api.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.billing.invoice.model.Invoice;
import com.api.billing.invoice.model.InvoiceDateInput;
import com.api.billing.invoice.model.PaymentHistoryInput;
import com.api.billing.model.delivery.Delivery;
import com.api.billing.model.delivery.DeliveryDateInput;
import com.api.billing.model.delivery.DeliveryDetail;
import com.api.billing.model.delivery.DeliveryPackageInput;
import com.api.billing.model.product.Product3;
import com.api.repository.DeliveryRepository;
import com.api.repository.InvoiceDetailRepository;
import com.api.service.DeliveryService;

@Service
public class DeliveryServiceBean implements DeliveryService
{

	@Autowired
    private DeliveryRepository deliveryrepository;

	
	@Override
	public List<Delivery> getDeliveryByDate(DeliveryDateInput idi) 
	{
		// TODO Auto-generated method stub
		List<Delivery> deliverylist = deliveryrepository.getDeliveryByDate(idi);
		return deliverylist;
	}

	@Override
	public List<Package> getPackageData(DeliveryPackageInput idi) 
	{
		// TODO Auto-generated method stub
		List<Package> packagelist = deliveryrepository.getPackage(idi);
		return packagelist;
	}
	
	
	@Override
	public int insertDeliveryDetail(PaymentHistoryInput idi) {
		// TODO Auto-generated method stub
		int result = deliveryrepository.insertDeliveryDetail(idi);
	
		if(result > 0) return 1;
		else return 0;
		
	}
	

	/*paging */
	@Override
	public int getDeliveryTotCount(DeliveryDateInput idi) 
	{
		// TODO Auto-generated method stub
		int result = deliveryrepository.getDeliveryTotCount(idi) ;
		return result;
	}


	@Override
	public int getPackageTotalCount(DeliveryPackageInput idi) 
	{
		// TODO Auto-generated method stub
		int result = deliveryrepository.getPackageTotalCount(idi) ;
		return result;
	}
	


}
