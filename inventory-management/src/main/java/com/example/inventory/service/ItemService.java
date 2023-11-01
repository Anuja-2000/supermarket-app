package com.example.inventory.service;

import com.example.inventory.dto.ItemRequest;
import com.example.inventory.model.Item;
import com.example.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(ItemRequest itemRequest){
        UUID id = UUID.randomUUID();
        Item item = new  Item(id.toString(),
                itemRequest.getName(),
                itemRequest.getDescription(),
                itemRequest.getQuantity(),
                itemRequest.getPrice(),
                itemRequest.getAddedBy(),
                new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));

        itemRepository.save(item);
        System.out.println("item "+item.getId()+"is saved");
    }
}
