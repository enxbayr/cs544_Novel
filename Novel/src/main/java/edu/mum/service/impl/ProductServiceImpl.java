package edu.mum.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Menu;
import edu.mum.dao.ProductDao;
import edu.mum.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
	private ProductDao productDao;

	public List<Menu> getAllProducts() {
		return productDao.getAllProducts();
	}

	public Menu getProductById(String productID) {
		return productDao.getProductById(productID);
	}
	
	public List<Menu> getProductsByCategory(String category) {
		return productDao.getProductsByCategory(category);
	}

 	public void addProduct(Menu product) {
		   productDao.save(product);
	}
	
	public Menu get(long productID) {
		return productDao.findOne(productID);
	}
	
	// Hydrate Category
	public Menu getWithCategory(long productID) {
		Menu product = productDao.findOne(productID);
		if (product.getCategories() != null && product.getCategories().size() > 0)
			product.getCategories().get(0).getId();
		return product;
		
	}
	
	public List<Menu> getProductsByDescOrder() {
		return productDao.getProductsByDescOrder();
	}
 
 


}
