package com.api.billing.model.code;

public class CodeGroupDetail {

	private String codeGroupId;
	private String code;
	private String codeName;
	private String codeDescription;
	private int sortingOrder;
	private String effectStartDateTime;
	private String effectEndDateTime;
	private String subCodeGroupId;
	
	public String getCodeGroupId() {
		return codeGroupId;
	}
	public void setCodeGroupId(String codeGroupId) {
		this.codeGroupId = codeGroupId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeDescription() {
		return codeDescription;
	}
	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}
	public int getSortingOrder() {
		return sortingOrder;
	}
	public void setSortingOrder(int sortingOrder) {
		this.sortingOrder = sortingOrder;
	}
	public String getEffectStartDateTime() {
		return effectStartDateTime;
	}
	public void setEffectStartDateTime(String effectStartDateTime) {
		this.effectStartDateTime = effectStartDateTime;
	}
	public String getEffectEndDateTime() {
		return effectEndDateTime;
	}
	public void setEffectEndDateTime(String effectEndDateTime) {
		this.effectEndDateTime = effectEndDateTime;
	}
	public String getSubCodeGroupId() {
		return subCodeGroupId;
	}
	public void setSubCodeGroupId(String subCodeGroupId) {
		this.subCodeGroupId = subCodeGroupId;
	}
	
}
