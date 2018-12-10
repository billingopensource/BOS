package com.api.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.billing.model.product.Discount;
import com.api.billing.model.product.DiscountSearchBar;
import com.api.billing.model.product.Product3;
import com.api.billing.model.product.ProductInput;
import com.api.billing.model.product.ProductPackage;
import com.api.billing.model.product.ProductPackageInput;
import com.api.repository.ProductRepository;
import com.api.service.ProductService;

@Service
@Transactional
public class ProductLogic implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Discount> findDiscountBySearchBar(DiscountSearchBar discountSearchBar) {
		// TODO Auto-generated method stub
		List<Discount> discount = productRepository.findDiscountBySearchBar(discountSearchBar);
		return discount;
	}

	@Override
	public Discount findDiscountId() {
		// TODO Auto-generated method stub
		Discount discount = productRepository.findDiscountId();
		return discount;
	}

	@Override
	public void saveDiscount(Discount discount) {
		// TODO Auto-generated method stub
		productRepository.saveDiscount(discount);
	}

	@Override
	public void saveDiscountUpdate(Discount discount) {
		// TODO Auto-generated method stub
		productRepository.saveDiscountUpdate(discount);
	}

	@Override
	public List<Product3> getProductlist(ProductInput idi) 
	{
		// TODO Auto-generated method stub
		List<Product3> productlist = productRepository.getProductlist(idi);
		return productlist;
	}

	@Override
	public List<Product3> getProductselectlist(ProductInput idi) {
		// TODO Auto-generated method stub
		List<Product3> productlist = productRepository.getProductselectlist(idi);
		return productlist;
	}
	
	@Override
	public List<ProductPackage> getProductPackagelist(ProductPackageInput idi) 
	{
		// TODO Auto-generated method stub
		List<ProductPackage> packagelist = productRepository.getProductPackagelist(idi);
		return packagelist;
	}

	@Override
	public Product3 findProductid() {
		// TODO Auto-generated method stub
		Product3 product = productRepository.findProductid();
		return product;
	}
	
	@Override
	public ProductPackage findProductPackageid() {
		// TODO Auto-generated method stub
		ProductPackage productpackage = productRepository.findProductPackageid();
		return productpackage;
	}

	@Override
	public void saveProduct(Product3 product) {
		// TODO Auto-generated method stub
		productRepository.saveProduct(product);
	}

	@Override
	public void updateProduct(Product3 product) {
		// TODO Auto-generated method stub
		productRepository.updateProduct(product);	
	}

	@Override
	public void updateProductPackage(ProductPackage productpackage) {
		// TODO Auto-generated method stub
		productRepository.updateProductPackage(productpackage);
	}

	@Override
	public void saveProductPackage(ProductPackage productpackage) {
		// TODO Auto-generated method stub
		productRepository.saveProductPackage(productpackage);
	}

	@Override
	public List<Product3> findProductInfoByProductId(Product3 productId) {
		// TODO Auto-generated method stub
		List<Product3> product = productRepository.findProductInfoByProductId(productId);
		return product;
	}
	
	@Override
	public Discount findDiscountByDiscountId(Discount discount) {
		// TODO Auto-generated method stub
		discount = productRepository.findDiscountByDiscountId(discount);
		return discount;
	}

	@Override
	public Product3 findProductByProductId(Product3 product) {
		// TODO Auto-generated method stub
		product = productRepository.findProductByProductId(product);
		return product;
	}

	@Override
	public ProductPackage findProductPackageByMainProductId(ProductPackage productPackage) {
		// TODO Auto-generated method stub
		productPackage = productRepository.findProductPackageByMainProductId(productPackage);
		return productPackage;
	}

	@Override
	public int getProductTotCount(ProductInput idi) {
		return productRepository.getProductTotCount(idi);
	}


	
}
