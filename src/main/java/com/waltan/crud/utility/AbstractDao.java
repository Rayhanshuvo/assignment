package com.waltan.crud.utility;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.waltan.crud.product.ProductEntity;
import com.waltan.crud.sales_invoice.SalesInvoiceEntity;


@Repository
@Transactional
public abstract class AbstractDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public <T> void saveEntity(Object obj) {
		// getSession().save( obj);

		try {
			getSession().saveOrUpdate(obj);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("");
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<?> clazz) {
		return getSession().createCriteria(clazz).list();
	}
	
	
	public ProductEntity getProductById(Long id) {
		// TODO Auto-generated method stub
		ProductEntity productEntity= new ProductEntity();
		productEntity=getSession().find(ProductEntity.class, id);
		return productEntity;
	}
	
	
	public SalesInvoiceEntity getSaleId(Long id) {
		// TODO Auto-generated method stub
		SalesInvoiceEntity salesInvoiceEntity= new SalesInvoiceEntity();
		salesInvoiceEntity=getSession().find(SalesInvoiceEntity.class, id);
		return salesInvoiceEntity;
	}
	
	
	/*
	 * public <T> Object findById(Class<?> clazz, T id) { return
	 * getSession().createCriteria(clazz).add(Restrictions.idEq(id)).uniqueResult();
	 * }
	 */
    
    public List<ProductEntity> getProductsId(Long id) {
    	

    	
    	
		Criteria criteria = getSession().createCriteria(ProductEntity.class);
		criteria.add(Restrictions.eq("productId", id));
		List<ProductEntity> prd= criteria.list();
		System.err.println();
		 return prd;
		
	}
	
    
    
}
