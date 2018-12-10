package com.api.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.billing.model.code.CodeGroupDetail;
import com.api.repository.CodeRepository;
import com.api.service.CodeService;

@Service
@Transactional
public class CodeLogic implements CodeService {

	@Autowired
	private CodeRepository codeRepository;
	
	@Override
	public List<CodeGroupDetail> finCodeGroupDetailByCodeGroupId(String codeGroupId) {
		List<CodeGroupDetail> codeGroupDetail = codeRepository.finCodeGroupDetailByCodeGroupId(codeGroupId);
		return codeGroupDetail;
	}

}
