package edu.mum.dao;


import java.util.List;
import java.util.Map;
import java.util.Set;

 import edu.mum.domain.Menu;

import edu.mum.domain.User;


	public interface ProductDao extends GenericDao<Menu>  
	{
	  Menu getProductByProductId(String key);
	
		public List<Menu> getAllProducts();
 	
	    Menu getProductById(String key);
		
		List<Menu> getProductsByCategory(String category);

  
		List<Menu> getProductsByDescOrder();

 
	}

