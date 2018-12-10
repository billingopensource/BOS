package com.api.service;

import java.util.List;

import com.api.billing.model.code.CodeGroupDetail;

public interface CodeService {
	
	List<CodeGroupDetail> finCodeGroupDetailByCodeGroupId(String codeGroupId);
}
