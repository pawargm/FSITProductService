package ProductService.Mandinet.product.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import ProductService.Mandinet.product.model.Product;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository{
 @Autowired
 MongoTemplate mongoTemplate;

 public List<Product> findProductsByProperties(String category, String name) {
	Pageable page = null;
	System.out.println("In findProductsByProperties ");
	// TODO Auto-generated method stub
	 final Query query = new Query();//.with(page);
	 final List<Criteria> criteria = new ArrayList<Criteria>();
	 
	 if (name != null && !name.isEmpty())
		 criteria.add(Criteria.where("productName").is(name));
	 
	 if (category != null && !category.isEmpty())
		 criteria.add(Criteria.where("category").is(category));

	 System.out.println(criteria.get(0));
	 System.out.println(criteria.get(1));
	 if(!criteria.isEmpty()) {
		 query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
	 }
	 System.out.println(query);
	return mongoTemplate.find(query,Product.class);
}
 

}