package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;


@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/* get a product by Id */

	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	/* fetched all Products */
	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	/* add product in the table */
	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/* update a product in the table */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {

		try {
			product.setActive(false);

			return this.update(product);

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	/* business method for fetched active Product*/
	
	@Override
	public List<Product> listActiveProduct() {
		String selectActiveProduct ="FROM Product WHERE active = :active";
		return sessionFactory.
				getCurrentSession().
				  createQuery(selectActiveProduct,Product.class).
				    setParameter("active", true).getResultList();
	}

	/*business method to fetched products by category*/
	
	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String selectActiveProductByCategory ="FROM Product WHERE active = :active AND categoryId = :categoryId ";
		return sessionFactory.
				getCurrentSession().
				  createQuery(selectActiveProductByCategory,Product.class).
				    setParameter("active", true).
				    setParameter("categoryId",categoryId).getResultList();
	}

	
	/*business method fetched latest products*/
	@Override
	public List<Product> getLatestActiveProduct(int count) {
		return sessionFactory.
				getCurrentSession().
				  createQuery("FROM Product WHERE active = :active ORDER BY id ",Product.class).
				    setParameter("active", true).
				      setFirstResult(0).
				      setMaxResults(count)
				        .getResultList();
	}

}
