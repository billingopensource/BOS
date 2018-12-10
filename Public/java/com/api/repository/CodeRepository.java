package com.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.api.billing.model.code.CodeGroupDetail;

@Mapper
@Repository
public interface CodeRepository {
	
	List<CodeGroupDetail> finCodeGroupDetailByCodeGroupId(String codeGroupId);
	
}
