package com.api.billing.model.delivery;

import com.api.model.Criteria;

/**
 * @author P069556
 * 패키지구성품 내역 조회조건 입력값 처리용
 */

public class DeliveryPackageInput  extends Criteria
{
	private String packageid;        //패키지ID
	private String deliverydate;     //배송일자
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
	public String getPackageid() {
		return packageid;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	
	
}
