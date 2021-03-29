package ProductService.Mandinet.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProductService.Mandinet.product.model.Product;
import ProductService.Mandinet.product.service.ProductService;

@RestController
public class PorductController {
	
	@Autowired
	ProductService prodService;
	
	@RequestMapping(value="/product/addProduct", method=RequestMethod.POST)
	public HttpStatus addProduct(@RequestBody Product prod) {

		if(prodService.addProduct(prod) == 1) {
			return HttpStatus.OK;
		}
		
		return HttpStatus.NOT_FOUND;
	}
	
	@RequestMapping(value="/product/getAllProd", method=RequestMethod.GET)
	public List<Product> getAllProd() {
		List<Product> lst = prodService.getAllProd();
		return lst;
	}
	
	
	@RequestMapping(value="/product/removeProduct", method=RequestMethod.DELETE)
	public HttpStatus removeProduct( @RequestParam String ownerid, @RequestParam String productname ) {
		
		String productid = ownerid + productname;
		if(prodService.removeProduct(productid) == 1) {
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}
	
	@RequestMapping(value="/product/getProdImg", method=RequestMethod.GET)
	public String getProdImg(@RequestParam String ownerid, @RequestParam String productname) {
		String productid = ownerid + productname;
		return prodService.getProdImg(productid);
	}
	
	//Purchase Product and Edit Product is for future scope
	
	@RequestMapping(value="/product/filterByCategory", method=RequestMethod.GET)
	public List<Product> getProdByCategory(@RequestParam String category) {
		System.out.println("Category get "+category);
		List<Product> lstProduct = prodService.getProdByCategory(category);
		
		if(lstProduct.size() == 0) {
			System.out.println("ERROR::getProdByCategory:Their is not"
					+ "not any product of such category:   "+category);
		}
		return lstProduct;
	}

	@RequestMapping(value="/product/getProdById", method=RequestMethod.GET)
	public Product getProdById(@RequestParam String prodid) {
		
		Product Product = prodService.getProdById(prodid);
		
		if(Product == null) {
			System.out.println("ERROR::getProdById:Their is not"
					+ "not any product of such prodid:   "+prodid);
		}
		return Product;
	}
	@RequestMapping(value="/product/filterByName", method=RequestMethod.GET)
	public List<Product> getProdByName(@RequestParam String name) {
		List<Product> lstProduct = prodService.getProdByName(name);
		
		if(lstProduct.size() == 0) {
			System.out.println("ERROR::getProdByNam:Their is not"
					+ "not any product of such name:   "+name);
		}
		return lstProduct;
	}

	@RequestMapping(value="/product/filterByNameCategory", method=RequestMethod.GET)
	public List<Product> getProdByNameCategory(@RequestParam String category, 
			@RequestParam String name) {
		List<Product> lstProduct = prodService.getProdByNameCategory(category, name);
		
		if(lstProduct.size() == 0) {
			System.out.println("ERROR::getProdByNameCategory:Their is not"
					+ "not any product of such category: "+category+ "name: "+name);
		}
		return lstProduct;
	}

	
}