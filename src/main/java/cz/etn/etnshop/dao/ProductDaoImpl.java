package cz.etn.etnshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {

	@Override
	public List<Product> getProducts() {
		Session currentSession = this.getSession();
		Query<Product> myQuery = currentSession.createQuery("from Product ", Product.class);
		List<Product> products = myQuery.getResultList();
		return products;
	}

	@Override
	public Product getProduct(int theId) {		
		Session currentSession = this.getSession();
		
		Product theProduct = currentSession.get(Product.class, theId);
		return theProduct;
	}
	
	@Override
	public void saveProduct(Product myProduct) {
		Session currentSession = this.getSession();
		currentSession.saveOrUpdate(myProduct);		
	}
	
	@Override
	public void deleteProduct(int theId) {
		Session currentSession = this.getSession();
		
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
	}
}
