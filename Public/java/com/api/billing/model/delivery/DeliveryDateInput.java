package com.api.billing.model.delivery;

import com.api.model.Criteria;

/**
 * @author P069556
 * 배송대상리스트 조회조건 입력값 처리용
 */

public class DeliveryDateInput extends Criteria
{
	private String fromDateD;   //배송시작일
	private String toDateD;     //배송종료일
	private String deliveryyn;  //배송여부
	/*ID mapping*/
	private String username;
	private int providernumber;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProvidernumber() {
		return providernumber;
	}
	public void setProvidernumber(int providernumber) {
		this.providernumber = providernumber;
	}
	/*ID mapping*/
	public String getFromDateD() {
		return fromDateD;
	}
	public String getToDateD() {
		return toDateD;
	}
	public String getDeliveryyn() {
		return deliveryyn;
	}
	public void setFromDateD(String fromDateD) {
		this.fromDateD = fromDateD;
	}
	public void setToDateD(String toDateD) {
		this.toDateD = toDateD;
	}
	public void setDeliveryyn(String deliveryyn) {
		this.deliveryyn = deliveryyn;
	}

}
