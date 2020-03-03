package com.MockitoSpringTesting.MockitoSpringTesting.business;

import com.MockitoSpringTesting.MockitoSpringTesting.data.ItemRepository;
import com.MockitoSpringTesting.MockitoSpringTesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {
    @Autowired
    private ItemRepository repository;

    public Item retriveHardcodedItem() {
        return new Item (1,"karthik",5, 500);
    }

    public List<Item> retriveAllItems(){
        List<Item> items = repository.findAll();
        for(Item item : items){
            item.setValue(item.getPrice()*item.getCount());
        }
        return repository.findAll();
    }


}
