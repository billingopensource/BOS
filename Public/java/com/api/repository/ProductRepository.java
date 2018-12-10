package com.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.api.billing.model.product.Discount;
import com.api.billing.model.product.DiscountSearchBar;
import com.api.billing.model.product.Product3;
import com.api.billing.model.product.ProductInput;
import com.api.billing.model.product.ProductPackage;
import com.api.billing.model.product.ProductPackageInput;

@Mapper
@Repository
public interface ProductRepository {

	List<Discount> findDiscountBySearchBar(DiscountSearchBar discountSearchBar);

	Discount findDiscountId();

	void saveDiscount(Discount discount);

	void saveDiscountUpdate(Discount discount);
	
	List<Product3> getProductlist(ProductInput idi);	
	List<Product3> getProductselectlist(ProductInput idi);
	List<ProductPackage> getProductPackagelist(ProductPackageInput idi);
	
	List<Product3> findProductInfoByProductId(Product3 productId);
	
	Product3 findProductid();
	ProductPackage findProductPackageid();
	
	void saveProduct(Product3 product);
	void updateProduct(Product3 product);
	void updateProductPackage(ProductPackage productpackage);
	void saveProductPackage(ProductPackage productpackage);
	
	Discount findDiscountByDiscountId(Discount discount);
	
	Product3 findProductByProductId(Product3 product);
	
	ProductPackage findProductPackageByMainProductId(ProductPackage productPackage);
	
	/*paging cnt */
	int getProductTotCount(ProductInput idi);
	

}
