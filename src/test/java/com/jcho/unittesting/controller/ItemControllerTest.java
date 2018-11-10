package com.jcho.unittesting.controller;

import com.jcho.unittesting.model.Item;
import com.jcho.unittesting.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void getItemBasic() throws Exception {
        // Call GET "/hello-world" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:Ball,price:10.0,quantity:10}"))
                .andReturn();

    }

    @Test
    public void retrieveFromItemService() throws Exception {

        when(itemService.retrieveItem()).thenReturn(new Item(2, "hat", 20.99, 15));
        // Call GET "/hello-world" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:hat,price:20.99,quantity:15}"))
                .andReturn();
    }

    /*@Test
    public void addItem() throws Exception {

        when(itemService.addItem()).thenReturn();
        RequestBuilder request = MockMvcRequestBuilders
                .get("/add-item")
                .content("[\"id\":1,\"name\":\"Ball Marker\",\"price\":10,\"quantity\":25}")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("/item/")))
                .andReturn();
    }*/
}