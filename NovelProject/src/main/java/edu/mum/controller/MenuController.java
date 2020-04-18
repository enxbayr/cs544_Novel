package edu.mum.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import edu.mum.domain.Menu;
import edu.mum.service.MenuService;

@RestController
@CrossOrigin
@RequestMapping({"/menu"})
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Menu> getMenu() {
		return menuService.getMenuList();

	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public Menu getMenuByID(@PathVariable Integer id){

		return  menuService.getAllByID(id);
	}

	@RequestMapping(value ="/edit", method=RequestMethod.PUT)
	public Menu editMenu(@RequestBody Menu menu) {

		this.menuService.update(menu);
		return menu;
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public Menu addMenu(@RequestBody Menu menu) {

		 menuService.add(menu);
		 return menu;
	}
	
	@RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
	public String deleteMenu(@PathVariable Integer id) {

		Menu m = menuService.getAllByID(id);

		menuService.delete(m);
		return "deleted";
	}
	
	
}
