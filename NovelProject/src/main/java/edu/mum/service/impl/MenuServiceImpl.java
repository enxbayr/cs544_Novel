package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.MenuDao;
import edu.mum.domain.Menu;
import edu.mum.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> getMenuList() {
		// TODO Auto-generated method stub		
		return  menuDao.findAll();
	}

	@Override
	public Menu getAllByID(long menuId) {
		// TODO Auto-generated method stub
		return menuDao.getById(menuId);
	}

	@Override
	public void add(Menu menu) {
		// TODO Auto-generated method stub
		
		menuDao.save(menu);
		
	}

	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.save(menu);
	}

	@Override
	public void delete(Menu menu) {
		menuDao.delete(menu);
	}


}
