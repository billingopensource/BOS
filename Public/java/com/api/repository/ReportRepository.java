package com.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.api.report.model.ArticleInput;
import com.api.report.model.ArticleOutput;
import com.api.report.model.CustomerContractTotalOutput;
import com.api.report.model.InvoiceMonthlyOutput;
import com.api.report.model.InvoiceReportOutput;
import com.api.report.model.ProductRatioOutput;
import com.api.report.model.reportInput;


@Mapper
@Repository
public interface ReportRepository {

	CustomerContractTotalOutput getTotalCustomerandContract(reportInput monthdate);
	InvoiceReportOutput getInvoiceReportOutput(reportInput monthdate);
	List<InvoiceMonthlyOutput> getInvoiceReportMonthOutput(reportInput monthdate);
	
	List<ProductRatioOutput> getRatioProduct(reportInput monthdate);
	List<ProductRatioOutput> getRatioProductRank(reportInput monthdate);
	
	/*article*/
	int insertArticle(ArticleInput aci);
	List<ArticleOutput> getArticle(reportInput monthdate);
	int updateArticle(int articlenum);
}
