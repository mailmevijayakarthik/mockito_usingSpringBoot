package com.MockitoSpringTesting.MockitoSpringTesting.controller;

import com.MockitoSpringTesting.MockitoSpringTesting.business.ItemBusinessService;
import com.MockitoSpringTesting.MockitoSpringTesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item helloworld(){
        return new Item (1,"vk",10, 100);
    }

    @GetMapping("/item-from-businessservice")
    public Item itemFromBusinessService(){

        return itemBusinessService.retriveHardcodedItem();
    }


    @GetMapping("/all-items-database")
    public List<Item> itemFromDataBase(){

        return itemBusinessService.retriveAllItems();
    }


}
