package com.MockitoSpringTesting.MockitoSpringTesting.business;

import com.MockitoSpringTesting.MockitoSpringTesting.data.ItemRepository;
import com.MockitoSpringTesting.MockitoSpringTesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/* Using mockito
* When --> dataservicemock --> retriveallData --> should return new int[]{1,2,3}
*
* 4 Changes by using Inbuilt Mockito Annotations
* Use @InjectMocks to the actual Business Implementation
* Use @Mock to define mock implementation
* Remove @before no need to set dataservice
* Use @RunWith(MockitoJUnitRunner.class) on the main class under test
* */

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessMockTest_UsingInbuiltMockAnnotations {

    @InjectMocks
    ItemBusinessService business;
    @Mock   // To mock the dataservice
    ItemRepository datarepository;



    /*
    * Mocking the Business layer along with ItemRepository mock
    *
    * */
    @Test
    public void Retriveallbymockingdataservice_basic(){

        // When --> dataservicemock --> retriveallData --> should return new int[]{1,2,3}
        when(datarepository.findAll()).thenReturn(Arrays.asList(new Item(100,"Mock_Arul",3,300),new Item(200,"Mock_Karthik",5,200)));
        List<Item> items = business.retriveAllItems();
        assertEquals(300,items.get(0).getCount());
        assertEquals(900,items.get(0).getValue());




    }



}
