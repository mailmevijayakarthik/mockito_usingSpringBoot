package com.MockitoSpringTesting.MockitoSpringTesting.controller;

import com.MockitoSpringTesting.MockitoSpringTesting.business.ItemBusinessService;
import com.MockitoSpringTesting.MockitoSpringTesting.model.Item;
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

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value= ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;


    /*
    * Need to call /dummy-item
    * Verify the JSON response
    "id": 1,
    "name": "vk",
    "price": 10,
    "count": 100
    }
    *
    *
    * */
    @Test
    public void testHelloWorld_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":1,\"name\":\"vk\",\"price\":10,\"count\":100}"))
                .andReturn();

    }


    /*
    * The below method needs ItemBusiness Service  component to be available but the below will not load it
    *
    * But we dont need to test the code inside ItemBusiness Service  component --> accomplished by @MockBean
    *
    * Mocking the Business Service implementation alone
    *
    * */
    @Test
    public void testItemfromBusinessService() throws Exception {
        when(businessService.retriveHardcodedItem()).thenReturn(new Item(7,"Mock_Arul",3, 300) );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-businessservice")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":7,\"name\":\"Mock_Arul\",\"price\":3,\"count\":300}"))
                .andReturn();

    }

    /*
    * Mocking the Data Service layer
    * */

    @Test
    public void testAllItemfromBusinessService() throws Exception {
        when(businessService.retriveAllItems()).thenReturn(Arrays.asList(new Item(100,"Mock_Arul",3,300),new Item(200,"Mock_Karthik",5,200)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "\n" +
                                "[{\"id\":100,\"name\":\"Mock_Arul\",\"price\":3,\"count\":300},{\"id\":200,\"name\":\"Mock_Karthik\",\"price\":5,\"count\":200}]"))
                .andReturn();

    }

}
