package edu.mum.service;

import edu.mum.domain.Item;


import java.util.List;

public interface ItemService {
    List<Item> getItemList();
    Item  getAllByID(long itemID);

    public void add(Item item);
    public void update(Item item);
    public void delete(Item item);
}
