package edu.mum.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.User;
import edu.mum.domain.Menu;

import edu.mum.dao.ProductDao;

	@Repository
	public class ProductDaoImpl extends GenericDaoImpl<Menu> implements ProductDao
	{
		
		public ProductDaoImpl() {
			super.setDaoType(Menu.class );
			}


	  public Menu getProductByProductId(String key) {
		 return  this.getProductByProductId(key);
	  }
	
 		public List<Menu> getAllProducts() {
	    	return this.findAll();
	    }
 	
	    public Menu getProductById(String key) {	     
			Query query = entityManager.createQuery("select p from Product p  where p.productId =:productId");
			return (Menu) query.setParameter("productId", key).getSingleResult();

	    }
		
		public List<Menu> getProductsByCategory(String category) {
			
			Query query = entityManager.createQuery("select p from Product p where p.category = :category");
			 
			return (List<Menu>) query.setParameter("category", category).getResultList();
 		}

 
		@SuppressWarnings("unchecked")
		public List<Menu> getProductsByDescOrder() {
			Query query = entityManager.createQuery("select p from Product p order by p.productId desc");
			return (List<Menu>) query.getResultList();

		}

 
	}

