package com.MockitoSpringTesting.MockitoSpringTesting.data;

import com.MockitoSpringTesting.MockitoSpringTesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer > {

}
