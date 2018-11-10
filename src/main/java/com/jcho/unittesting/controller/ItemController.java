package com.jcho.unittesting.controller;

import com.jcho.unittesting.model.Item;
import com.jcho.unittesting.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 10);
    }

    @GetMapping("/item-service")
    public Item itemFromItemService() {
        return itemService.retrieveItem();
    }

    @GetMapping("/all-items")
    public List<Item> items() {
        return itemService.retrieveAllItems();
    }
}
