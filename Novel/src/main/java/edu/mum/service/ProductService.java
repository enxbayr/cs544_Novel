package edu.mum.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Menu;

public interface ProductService {

	List<Menu> getAllProducts();

	Menu getProductById(String productID);
	
	List<Menu> getProductsByCategory(String category);

 	void addProduct(Menu product);

	Menu get(long id);
 
	List<Menu> getProductsByDescOrder();

	public Menu getWithCategory(long productID);
}
