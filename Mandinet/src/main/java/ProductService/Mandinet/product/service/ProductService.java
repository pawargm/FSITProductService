package ProductService.Mandinet.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductService.Mandinet.product.model.Product;
import ProductService.Mandinet.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository product;
	
	//Used by owner
	public int addProduct(Product proObj) {
		
		proObj.setProductId(proObj.getOwnerId()+proObj.getProductName());
		product.save(proObj);
		return 1;
	}
	
	//Used by owner
	public int removeProduct(String productId) {
		product.deleteByproductId(productId);
		//product.delete(product.findByproductId(productId));
		return 1;
	}
	
	public String getProdImg(String prodId) {
		Product pobj = product.findByproductId(prodId);
		if(pobj == null) {
			System.out.println("ERROR::getProdImg:No product found");
			return null;
		}
		return pobj.getImgURL();
	}
	
	public List<Product> getProdByCategory(String category) {
		
		List<Product> lstProd = product.findBycategory(category);
		
		
		if(lstProd.size() == 0 ) {
			System.out.println("ERROR::getProdByCategory:No product");
			return null;
		}
		
		return lstProd;
	}
	
	public Product getProdById(String productId) {
		
		Product lstProd =  product.findByproductId(productId);
		if(lstProd == null ) {
			System.out.println("ERROR::getProdById:No product");
			return null;
		}
		return lstProd;
	}
	
	public List<Product> getProdByName(String name) {
		
		List<Product> lstProd = product.findByproductName(name);
		
		
		if(lstProd.size() == 0 ) {
			System.out.println("ERROR::getProdByName:No product");
			return null;
		}
		
		return lstProd;
	}
	
	public List<Product> getProdByNameCategory(String category, String name) {
		
		List<Product> lstProd = product.findProductsByProperties(category, name);//product.findByproductNameIgnoreCaseContainingOrcategoryIgnoreCaseContaining(category, name);
		
		
		if(lstProd.size() == 0 ) {
			System.out.println("ERROR::getProdByNameCategory:No product");
			return null;
		}
		
		return lstProd;
	}

	public List<Product> getAllProd() {
		// TODO Auto-generated method stub
		List<Product> lst = product.findAll();
		return lst;
	}
	
	
	
	
}
