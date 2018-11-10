package com.jcho.unittesting.repository;

import com.jcho.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository repository;

    // uses data from data-h2.sql for test
    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }
}