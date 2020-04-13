package edu.mum.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Menu;

 

public interface ProductRepositoryLite {

	List <Menu> getAllProducts();
	
	Menu getProductById(String key);
	
	List<Menu> getProductsByCategory(String category);

	Set<Menu> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Menu product);		
}
