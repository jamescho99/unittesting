package com.jcho.unittesting.service;

import com.jcho.unittesting.model.Item;
import com.jcho.unittesting.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void retrieveAllItemsTest() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Ball", 10, 10),
                new Item(2, "Hat", 20, 25)));

        List<Item> items = itemService.retrieveAllItems();
        assertEquals(100, items.get(0).getValue(),0);
        assertEquals(500, items.get(1).getValue(),0);
    }
}