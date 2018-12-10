package com.api.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.billing.invoice.model.InvoiceDateInput;
import com.api.billing.login.model.User;
import com.api.billing.model.product.Discount;
import com.api.billing.model.product.DiscountSearchBar;
import com.api.billing.model.product.Product3;
import com.api.billing.model.product.ProductInput;
import com.api.billing.model.product.ProductPackage;
import com.api.billing.model.product.ProductPackageInput;
import com.api.model.Criteria;
import com.api.model.PageMaker;
import com.api.service.ProductService;
import com.api.service.UserService;

@RestController
@RequestMapping("product")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@Autowired 
	UserService userService;
		
	@RequestMapping(value = "/productmain", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewProductMain(Model model) {
		System.out.println("____________________viewProductMain____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/product/productmain");
		return modelAndView;
	}
	
	@RequestMapping(value = "/productmenu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ModelAndView viewProductMenu(Model model) {
		System.out.println("____________________viewProductMenu____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/product/productmenu");
		return modelAndView;
	}
	
	 /*��ǰ��ȸ*/
	 @RequestMapping(value = "/product-productlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewProductProductList(Model model) 
	 {
		System.out.println("===================viewProductProductList=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/product/product-productlist");
		return modelAndView;
	 }
		
	 /*��ǰ��ȸ search bar*/
	 @RequestMapping(value = "/searchbar-product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewSearchBarp(Model model) {
		System.out.println("===================searchbar-product=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/product/searchbar-product");
		return modelAndView;
	 }
	 
	 /* 패키지상품의 구성품추가시 selectbox로 상품리스트 가져오는 서비스 */
	 @RequestMapping(value = "/getProductselectlist", method = RequestMethod.GET)
	 public List<Product3> getProductselectlist(ProductInput productInput, Principal principal) {
		System.out.println("===================getProductselectlist=====================");
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		productInput.setProvidernumber(user.getProvidernumber());
		productInput.setUsername(user.getUsername());
		/*ID mapping*/
		List<Product3> productlist = productService.getProductselectlist(productInput);
		System.out.println("productlist.size = " + productlist.size());
		System.out.println("productlist = " + productlist);
		return productlist;
	 }
	 
	//각 상품리스트 row 가 클릭되었을 때 호출되는 서비스 정의
	 @RequestMapping(value = "/getpackageproduct/{mainproductid}", method = RequestMethod.GET)
	 public List<ProductPackage> getPackageproduct(@PathVariable(value = "mainproductid") String mainproductid,Model model){
		System.out.println("===================getPackageProduct=====================");
		System.out.println("mainproductid = " + mainproductid );
		ProductPackageInput ppInput = new ProductPackageInput();
		ppInput.setMainProductId(mainproductid);
		
		List<ProductPackage> packagelist = productService.getProductPackagelist(ppInput);
		System.out.println("ProductPackagelist = " + packagelist.size());
		for( int i=0 ; i< packagelist.size() ; i++  )
		{
			System.out.println("ProductPackagelist = " + packagelist.get(i).getPackageId());
			System.out.println("ProductPackagelist = " + packagelist.get(i).getCompositionproductName());
			System.out.println("ProductPackagelist = " + packagelist.get(i).getPriceamount());
		}
		return packagelist;
	 }
	
	 /* productregistPopup 신규등록 */
	 @RequestMapping(value = "/productregistDialog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ModelAndView viewproductregistDialog(Model model) {
		System.out.println("===================productregistDialog=====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("popup/productregistPopup");
		return modelAndView;
	 }
	 
	//신규 productID채번
	 @RequestMapping(value = "/findProductid", method = RequestMethod.GET)
	 public ModelAndView findProductid(Model model) {
		System.out.println("=================== findProductid =====================");
		ModelAndView modelAndView = new ModelAndView();
		Product3 product = productService.findProductid();
		System.out.println("=================== product.getProductId ====================="+product.getProductId());
		modelAndView.setViewName("admin/product/productidset");
		modelAndView.addObject("productResult", product);
		System.out.println("=================== findProductid =====================");
		return modelAndView;
	 }
	 
	//신규 pkgID채번
		 @RequestMapping(value = "/findProductPackageid", method = RequestMethod.GET)
		 public String findProductPackageid(Model model) {
			System.out.println("=================== findProductPackageid =====================");
			ModelAndView modelAndView = new ModelAndView();
			//Product3 product = productService.findProductid();
			ProductPackage productpackage = productService.findProductPackageid();
			System.out.println("=================== productpackage.getPackageId ====================="+productpackage.getPackageId());
			//modelAndView.setViewName("admin/product/ProductPackageidset");
			//modelAndView.addObject("productPackageResult", productpackage);
			System.out.println("=================== findProductPackageid end =====================");
			return productpackage.getPackageId();
			//return modelAndView;
		 }
	 
	//신규상품 등록
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public void saveProduct(@ModelAttribute Product3 product, Model model, Principal principal) {
		System.out.println("____________________saveProduct____________________");
		System.out.println("ProductId = " + product.getProductId());
		System.out.println("ProductType = " + product.getProductType());
		System.out.println("PackageYn = " + product.getPackageYn());
		System.out.println("ProductName = " + product.getProductName());
		System.out.println("ProductDescription = " + product.getProductDescription());
		System.out.println("priceAmount = " + product.getPriceAmount());
		System.out.println("taxObjectYn = " + product.getTaxObjectYn());
		System.out.println("packagePriceReferenceYn = " + product.getPackagePriceReferenceYn());
		System.out.println("packageVarietyYn = " + product.getPackageVarietyYn());
		System.out.println("suspendPriceAmount = " + product.getSuspendPriceAmount());
		System.out.println("providerNumber = " + product.getProviderNumber());
		System.out.println("SubscribeStartDateTime = " + product.getSubscribeStartDateTime());
		System.out.println("SubscribeEndDateTime = " + product.getSubscribeEndDateTime());
		System.out.println("RecurringDeleveryYn = " + product.getRecurringDeleveryYn());
		System.out.println("packagePriceBandwidth = " + product.getPackagePriceBandwidth());
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		product.setProvidernumber(user.getProvidernumber());
		product.setUsername(user.getUsername());
		/*ID mapping*/
		productService.saveProduct(product);
		return;
	}
	
	// 상품업데이트 시  modal 
	 @RequestMapping(value = "/productupdateDialog/{checkproductid}", method = RequestMethod.GET)
	 public ModelAndView viewproductupdateDialog(@PathVariable(value = "checkproductid") String checkproductid,Model model){
		 	System.out.println("===================findProductInfoByProductId=====================");
		 	System.out.println("checkproductid = " + checkproductid );
		Product3 productid = new Product3();
		productid.setProductId(checkproductid);		
		List<Product3> product = productService.findProductInfoByProductId(productid);
			System.out.println("product.size = " + product.size());
		for( int i=0 ; i< product.size() ; i++  )
		{
			System.out.println("getProductType = " + product.get(i).getProductType());
		}
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("checkproduct",product);
		System.out.println("checkproduct " );
		modelAndView.setViewName("popup/productupdatePopup");
		System.out.println("popup/productupdatePopup" );
		return modelAndView;
	 }
	 
	// 상품업데이트 처리
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public void updateProduct(@ModelAttribute Product3 product, Model model) {
		System.out.println("____________________updateProduct____________________");
		System.out.println("ProductId = " + product.getProductId());
		System.out.println("ProductType = " + product.getProductType());
		System.out.println("ProductName = " + product.getProductName());
		System.out.println("ProductDescription = " + product.getProductDescription());
		System.out.println("priceAmount = " + product.getPriceAmount());
		System.out.println("taxObjectYn = " + product.getTaxObjectYn());
		System.out.println("packagePriceReferenceYn = " + product.getPackagePriceReferenceYn());
		System.out.println("packageVarietyYn = " + product.getPackageVarietyYn());
		System.out.println("suspendPriceAmount = " + product.getSuspendPriceAmount());
		System.out.println("providerNumber = " + product.getProviderNumber());
		System.out.println("SubscribeStartDateTime = " + product.getSubscribeStartDateTime());
		System.out.println("SubscribeEndDateTime = " + product.getSubscribeEndDateTime());
		System.out.println("RecurringDeleveryYn = " + product.getRecurringDeleveryYn());
		System.out.println("packagePriceBandwidth = " + product.getPackagePriceBandwidth());
		productService.updateProduct(product);
		return;
	}
	
	// 패키지상품 업데이트시  modal
	 @RequestMapping(value = "/packageproductupdateDialog/{checkproductid}", method = RequestMethod.GET)
	 public ModelAndView viewpackageproductupdateDialog(@PathVariable(value = "checkproductid") String checkproductid,Model model){
		 	System.out.println("===================findpackageProductInfoByProductId=====================");
		 	System.out.println("checkproductid = " + checkproductid );
		Product3 productid = new Product3();
		productid.setProductId(checkproductid);		
		List<Product3> product = productService.findProductInfoByProductId(productid);
			System.out.println("product.size = " + product.size());
		for( int i=0 ; i< product.size() ; i++  )
		{
			System.out.println("getProductType = " + product.get(i).getProductType());
		}
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("checkproduct",product);
		System.out.println("checkproduct" );
		modelAndView.setViewName("popup/packageproductupdatePopup");
		System.out.println("popup/packageproductupdatePopup" );
		return modelAndView;
	 }
	 
	// 패키지상품 업데이트 처리
	@RequestMapping(value = "/updatepackageProduct", method = RequestMethod.POST)
	public void updateProductPackage(@ModelAttribute ProductPackage productpackage, Model model) {
		System.out.println("____________________updatepackageProduct____________________");
		System.out.println("getPackageId = " + productpackage.getPackageId());
		System.out.println("getPackageName = " + productpackage.getPackageName());
		System.out.println("getMainProductId = " + productpackage.getMainProductId());
		System.out.println("getCompositionProductId = " + productpackage.getCompositionProductId());
		System.out.println("getCompositionproductName = " + productpackage.getCompositionproductName());
		System.out.println("getEffectStartDateTime = " + productpackage.getEffectStartDateTime());
		System.out.println("getEffectEndDateTime = " + productpackage.getEffectEndDateTime());
		System.out.println("getLastHistoryYn = " + productpackage.getLastHistoryYn());
		
		productService.updateProductPackage(productpackage);
		return;
	}
	
	/// 패키지상품의 구성품 추가 처리
	@RequestMapping(value = "/savepackageProduct", method = RequestMethod.POST)
	public void saveProductPackage(@ModelAttribute ProductPackage productpackage, Model model, Principal principal) {
		System.out.println("____________________insertpackageProduct____________________");
		System.out.println("getPackageId = " + productpackage.getPackageId());
		System.out.println("getPackageName = " + productpackage.getPackageName());
		System.out.println("getMainProductId = " + productpackage.getMainProductId());
		System.out.println("getCompositionProductId = " + productpackage.getCompositionProductId());
		System.out.println("getCompositionproductName = " + productpackage.getCompositionproductName());
		System.out.println("getEffectStartDateTime = " + productpackage.getEffectStartDateTime());
		System.out.println("getEffectEndDateTime = " + productpackage.getEffectEndDateTime());
		System.out.println("getLastHistoryYn = " + productpackage.getLastHistoryYn());
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		productpackage.setProvidernumber(user.getProvidernumber());
		productpackage.setUsername(user.getUsername());
		/*ID mapping*/
		productService.saveProductPackage(productpackage);
		return;
	}	
	
	@RequestMapping(value = "/discountupdate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewDiscountUpdate(Model model) {
		System.out.println("____________________viewDiscountUpdate____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/product/discountupdate");
		return modelAndView;
	}

	@RequestMapping(value = "/searchbar-discount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView viewSearchBar(Model model) {
		System.out.println("____________________viewSearchBar____________________");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/product/searchbar-discount");
		return modelAndView;
	}
	
	@RequestMapping(value = "/findsearchbar", method = RequestMethod.GET)
	public ModelAndView findDiscountBySearchBar(@ModelAttribute DiscountSearchBar discountSearchBar, Model model, Principal principal) {
		System.out.println("____________________findDiscountBySearchBar____________________");
		ModelAndView modelAndView = new ModelAndView();
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		discountSearchBar.setProvidernumber(user.getProvidernumber());
		discountSearchBar.setUsername(user.getUsername());
		/*ID mapping*/
		List<Discount> discount = productService.findDiscountBySearchBar(discountSearchBar);
		System.out.println("discount.size() = " + discount.size());
		modelAndView.setViewName("admin/product/discountinformation");
		modelAndView.addObject("discountListResult", discount);
		return modelAndView;
	}
	
	@RequestMapping(value = "/finddiscountid", method = RequestMethod.GET)
	public ModelAndView findDiscountId(Model model) {
		System.out.println("____________________findDiscountId____________________");
		Discount discount = productService.findDiscountId();
		System.out.println("discount.getDiscountId() = " + discount.getDiscountId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/product/discountadd");
		modelAndView.addObject("discountListResult", discount);
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveDiscount", method = RequestMethod.POST)
	public void saveAddress(@ModelAttribute Discount discount, Model model, Principal principal) {
		System.out.println("____________________saveDiscount____________________");
		System.out.println("discount.getDiscountId() = " + discount.getDiscountId());
		System.out.println("discount.getDiscountName() = " + discount.getDiscountName());
		System.out.println("discount.getDiscountType() = " + discount.getDiscountType());
		System.out.println("discount.getDiscountState() = " + discount.getDiscountState());
		System.out.println("discount.getSubscribeStartDateTime() = " + discount.getSubscribeStartDateTime());
		System.out.println("discount.getSubscribeEndDateTime() = " + discount.getSubscribeEndDateTime());
		System.out.println("discount.getDiscountValue() = " + discount.getDiscountValue());
		System.out.println("discount.getDiscountDescription() = " + discount.getDiscountDescription());
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		discount.setProvidernumber(user.getProvidernumber());
		discount.setUsername(user.getUsername());
		/*ID mapping*/
		productService.saveDiscount(discount);
		return;
	}
	
	@RequestMapping(value = "/saveDiscountUpdate", method = RequestMethod.POST)
	public void saveDiscountUpdate(@ModelAttribute Discount discount, Model model) {
		System.out.println("____________________saveDiscountUpdate____________________");
		System.out.println("discount.getDiscountId() = " + discount.getDiscountId());
		System.out.println("discount.getDiscountName() = " + discount.getDiscountName());
		System.out.println("discount.getDiscountType() = " + discount.getDiscountType());
		System.out.println("discount.getDiscountState() = " + discount.getDiscountState());
		System.out.println("discount.getSubscribeStartDateTime() = " + discount.getSubscribeStartDateTime());
		System.out.println("discount.getSubscribeEndDateTime() = " + discount.getSubscribeEndDateTime());
		System.out.println("discount.getDiscountValue() = " + discount.getDiscountValue());
		System.out.println("discount.getDiscountDescription() = " + discount.getDiscountDescription());
		productService.saveDiscountUpdate(discount);
		return;
	}
	
	 /*페이징처리 된 상품리스트*/
	 @RequestMapping(value = "/getproductlist", method = RequestMethod.GET)
	 public Map<String, Object> getProductlist(@ModelAttribute ProductInput productInput,Model model, Principal principal) {
		System.out.println("===================getProductlist=====================");
		System.out.println("ProductInput = " + productInput.getProductType() );
		System.out.println("ProductInput = " + productInput.getProductName() );
		Map<String, Object> map = new HashMap<>();
		Criteria cri = productInput;
		/*ID mapping*/
		User user = userService.readUser(principal.getName());
		productInput.setProvidernumber(user.getProvidernumber());
		productInput.setUsername(user.getUsername());
		/*ID mapping*/
		map.put("lists",productService.getProductlist(productInput));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productService.getProductTotCount(productInput));

		System.out.println("getTotalCount=>" + pageMaker.getTotalCount());
		map.put("pageMaker", pageMaker); 
		return map ;
	 }
	
}
