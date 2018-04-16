package cz.etn.etnshop.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface ProductDao {


	List<Product> getProducts();

	void saveProduct(Product myProduct);

	Product getProduct(int theId);

	void deleteProduct(int theId);

}
