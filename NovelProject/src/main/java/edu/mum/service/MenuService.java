package edu.mum.service;

import java.util.List;

import edu.mum.domain.Menu;

public interface MenuService {

	List<Menu> getMenuList();
    Menu getAllByID(long menuId);
    
	public void add(Menu menu);
	public void update(Menu menu);
	public void delete(Menu menu);
	
	 
}
