package cz.etn.etnshop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cz.etn.etnshop.dao.Product;

public interface ProductService {

	List<Product> getProducts();

	void saveProduct(Product myProduct);

	Product getProduct(int theId);

	void deleteProduct(int theId);

}
