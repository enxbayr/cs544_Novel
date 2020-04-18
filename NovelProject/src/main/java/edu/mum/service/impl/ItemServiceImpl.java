package edu.mum.service.impl;

import javax.transaction.Transactional;

import edu.mum.dao.ItemDao;
import edu.mum.dao.MenuDao;
import edu.mum.domain.Item;
import edu.mum.service.ItemService;
import edu.mum.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getItemList() {

        return itemDao.findAll();
    }

    @Override
    public Item getAllByID(long itemID) {
        return itemDao.getOne(itemID);
    }

    @Override
    public void add(Item item) {
        itemDao.save(item);
    }

    @Override
    public void update(Item item) {
        itemDao.save(item);
    }

    @Override
    public void delete(Item item) {
    itemDao.delete(item);
    }
}
