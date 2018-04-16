package cz.etn.etnshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.dao.ProductDao;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product myProduct) {		
		productDao.saveProduct(myProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		return productDao.getProduct(theId);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		productDao.deleteProduct(theId);
	}

}
