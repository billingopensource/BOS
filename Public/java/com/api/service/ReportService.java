package com.api.service;

import java.util.List;

import com.api.report.model.ArticleInput;
import com.api.report.model.ArticleOutput;
import com.api.report.model.CustomerContractTotalOutput;
import com.api.report.model.InvoiceMonthlyOutput;
import com.api.report.model.InvoiceReportOutput;
import com.api.report.model.ProductRatioOutput;
import com.api.report.model.reportInput;

public interface ReportService {
	
	CustomerContractTotalOutput getTotalCustomerandContract(reportInput monthdate);
	InvoiceReportOutput getInvoiceReportOutput(reportInput monthdate);
	List<InvoiceMonthlyOutput> getInvoiceReportMonthOutput(reportInput monthdate);
	
	List<ProductRatioOutput> getRatioProduct(reportInput monthdate);
	List<ProductRatioOutput> getRatioProductRank(reportInput monthdate);
	
	/*ARTICLE notice */
	int insertArticle(ArticleInput aci);
	List<ArticleOutput> getArticle(reportInput monthdate);
	int updateArticle(int articlenum);
}
