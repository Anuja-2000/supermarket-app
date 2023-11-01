package com.example.inventory.repository;

import com.example.inventory.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository <Item,String> {

}
