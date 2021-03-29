package ProductService.Mandinet.product.repository;

import java.util.List;

import ProductService.Mandinet.product.model.Product;

public interface ProductCustomRepository {
	
	public List<Product> findProductsByProperties(String category, String name);

}
