package edu.mum.controller;

import java.util.List;

import edu.mum.domain.Menu;
import edu.mum.service.ItemService;
import edu.mum.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.mum.domain.Item;

@RestController
@CrossOrigin
@RequestMapping({ "/item" })
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getItem() {
		return itemService.getItemList();

	}

	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public Item getItemByID(@PathVariable Long id){

		return  itemService.getAllByID(id);
	}

	@RequestMapping(value ="/edit", method=RequestMethod.PUT)
	public String editMenu(@RequestBody Item item) {

		this.itemService.update(item);
		return "200";
	}

	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String addMenu(@RequestBody Item item) {

		itemService.add(item);
		return "201";
	}

	@RequestMapping(value = "/delete", method=RequestMethod.DELETE)
	public String deleteMenu(Long menuID) {

		itemService.delete(itemService.getAllByID(menuID));
		return "200";
	}
}
