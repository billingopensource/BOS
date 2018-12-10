package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.billing.model.code.CodeGroupDetail;
import com.api.service.CodeService;

@RestController
@RequestMapping("code")
public class CodeRestController {

	@Autowired
	private CodeService codeService;
	
	@RequestMapping(value = "/findcode/{codegroupid}", method = RequestMethod.GET)
	public List<CodeGroupDetail> finCodeGroupDetailByCodeGroupId(@PathVariable(value = "codegroupid") String codeGroupId) {
		System.out.println("____________________finCodeGroupDetailByCodeGroupId____________________");
		List<CodeGroupDetail> codeGroupDetail = codeService.finCodeGroupDetailByCodeGroupId(codeGroupId);
		return codeGroupDetail;
	}
}
