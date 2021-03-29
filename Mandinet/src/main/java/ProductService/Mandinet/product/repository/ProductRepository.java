package ProductService.Mandinet.product.repository;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ProductService.Mandinet.product.model.Product;
import ProductService.Mandinet.product.repository.ProductCustomRepository;

/**
 * 
 * @author Gopal.Pawar
 *@Indexed(name="productId",unique=true)
	private String productId;
	private int count;
	private String imgURL;
	private String productName;
	private String category;
	private String ownerId;
	private String description;
	private String price;
	
 */

@Repository
public interface ProductRepository extends MongoRepository<Product, String>,ProductCustomRepository {

	public List<Product> findByproductName(String productName);
	
	public List<Product> findBycategory(String category);
	public Product findByproductId(String productId);
	public void deleteByproductId(String Productid);
	//public List<Product> 
	//findByproductNameIgnoreCaseContainingOrcategoryIgnoreCaseContaining
	//(String productName, String productId);
	
	
	
	
	
}

