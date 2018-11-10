package com.jcho.unittesting.service;

import com.jcho.unittesting.model.Item;
import com.jcho.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveItem() {
        return new Item(1, "Ball", 10, 10);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();

        items.forEach(i -> i.setValue(i.getPrice() * i.getQuantity()));
        return items;
    }
}
